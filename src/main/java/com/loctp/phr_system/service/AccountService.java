package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.repository.IAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService  implements IAccountService{

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<AccountDTO> getAllAccount() {
        List<Account> rs = accountRepository.findAll();
        List<AccountDTO> response = new ArrayList<>();
        mapper.map(rs,response);
        return response;
    }
}
