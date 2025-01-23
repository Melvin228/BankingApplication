package com.melvin.banking.service;

import com.melvin.banking.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void performDeposit(Long id, BigDecimal amount);
    void performWithdrawal(Long id, BigDecimal amount);
    void performTransfer(Long fromId, Long toId, BigDecimal amount);
    Account createAccount(Account account);
    List<Account> findAccounts();
    List<Account> findAccountsByUserId(Long userId);
}
