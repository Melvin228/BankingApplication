package com.melvin.banking.service;

import com.melvin.banking.common.enums.TransactionStatus;
import com.melvin.banking.common.enums.TransactionType;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void recordTransaction(Account fromAccount, Account toAccount, TransactionType type, TransactionStatus status, BigDecimal amount, String remark);
    List<Transaction> findByAccountId(Long id);
}
