package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDTO>> getAll() {
        List<AccountDTO> rs = accountService.getAllAccount();
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO dto) {
        AccountDTO accountDTO = accountService.createAccount(dto);
        if (accountDTO.getId() == null) {
            return new ResponseEntity<>(accountDTO, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<Integer> disableAccountById(@NotNull @PathVariable Integer id) {
        if (accountService.disableAccountById(id)) {
            return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);

    }
}
