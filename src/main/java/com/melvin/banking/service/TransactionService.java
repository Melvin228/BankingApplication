package com.melvin.banking.service;

import com.melvin.banking.enums.TransactionStatus;
import com.melvin.banking.enums.TransactionType;
import com.melvin.banking.model.Account;

import java.math.BigDecimal;

public interface TransactionService {
    void recordTransaction(Account fromAccount, Account toAccount, TransactionType type, TransactionStatus status, BigDecimal amount, String remark);
}
