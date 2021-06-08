package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService  implements IAccountService{

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> rs = accountRepository.findAll();
        List<AccountDTO> dtos = rs
                .stream()
                .map(account -> mapper.map(account, AccountDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }


    @Override
    public void updatePasswordById(int id, String password) {
        Account account = accountRepository.getById(id);
        account.setPassword(password);
        accountRepository.save(account);
    }

    @Override
    public boolean checkStatus(int id) {
        Account account = accountRepository.getById(id);
        if(account.getStatus().equalsIgnoreCase("enable")){
            return true;
        }
        return false;
    }


}
