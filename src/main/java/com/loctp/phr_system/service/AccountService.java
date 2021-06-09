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

    private final String DISABLE = "disable";

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


    @Override
    public Boolean disableAccountById(Integer id) {
        Account account = accountRepository.findById(id).get();
        account.setStatus(DISABLE);
        account = accountRepository.save(account);
        if(account.getStatus().equalsIgnoreCase(DISABLE)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public AccountDTO createAccount(AccountDTO dto) {
        Account account = mapper.map(dto,Account.class);

        if(accountRepository.countByUsernameIgnoreCase(account.getUsername()) == 0){
            // NOT duplicated username => save it
            account = accountRepository.save(account);
        }

        return mapper.map(account,AccountDTO.class);

    }
}
