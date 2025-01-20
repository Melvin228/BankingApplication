package com.melvin.banking.service;

import com.melvin.banking.enums.TransactionStatus;
import com.melvin.banking.enums.TransactionType;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.Transaction;
import com.melvin.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public void recordTransaction(final Account fromAccount, final Account toAccount, final TransactionType type, TransactionStatus status, final BigDecimal amount, final String remark) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(fromAccount);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setRemark(remark);
        transaction.setStatus(status); // You can set status dynamically based on the outcome

        transactionRepository.save(transaction);
    }
}
