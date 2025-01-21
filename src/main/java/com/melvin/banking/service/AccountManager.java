package com.melvin.banking.service;

import com.melvin.banking.common.dto.AccountDTO;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountManager {
    public Account convertToEntity(final AccountDTO accountDTO) {
        // Example transformation logic
        final Account account = new Account();
        final User user = new User();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setType(accountDTO.getAccountType());
        account.setBalance(BigDecimal.ZERO);
        user.setPhoneNumber(accountDTO.getPhoneNumber());
        user.setEmail(accountDTO.getEmail());
        user.setUsername(accountDTO.getUsername());
        return account;
    }
}
