package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/all")
    public List<AccountDTO> getAll(){
        List<AccountDTO> rs= accountService.getAllAccount();
        return rs;
    }

}
