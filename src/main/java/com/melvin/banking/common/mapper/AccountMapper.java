package com.melvin.banking.common.mapper;

import com.melvin.banking.common.dto.AccountDTO;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountMapper {
    public static Account convertToEntity(final AccountDTO accountDTO) {
        final Account account = new Account();
        final User user = new User();
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setType(accountDTO.getAccountType());
        account.setBalance(BigDecimal.ZERO);
        user.setPhoneNumber(accountDTO.getPhoneNumber());
        user.setEmail(accountDTO.getEmail());
        user.setUsername(accountDTO.getUsername());
        account.setUser(user);
        return account;
    }
}
