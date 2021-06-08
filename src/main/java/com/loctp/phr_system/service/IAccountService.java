package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.model.Account;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IAccountService {
    void updatePasswordById(int id,String password);
    boolean checkStatus(int id);
    List<AccountDTO> getAllAccount();
    Boolean disableAccountById(Integer id);
    AccountDTO createAccount(AccountDTO dto);
}
