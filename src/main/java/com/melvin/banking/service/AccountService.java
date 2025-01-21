package com.melvin.banking.service;

import com.melvin.banking.model.Account;

import java.math.BigDecimal;

public interface AccountService {
    Account performDeposit(Long id, BigDecimal amount);
    Account performWithdrawal(Long id, BigDecimal amount);
    Account performTransfer(Long fromId, Long toId, BigDecimal amount);
    Account createAccount(Account account);
}
