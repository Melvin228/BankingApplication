package com.melvin.banking.service;

import com.melvin.banking.common.enums.TransactionStatus;
import com.melvin.banking.common.enums.TransactionType;
import com.melvin.banking.model.Account;
import com.melvin.banking.model.Transaction;
import com.melvin.banking.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public void recordTransaction(final Account fromAccount, final Account toAccount, final TransactionType type, final TransactionStatus status, final BigDecimal amount, final String remark) {
        final Transaction transaction = new Transaction();
        transaction.setSourceAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setType(type);
        transaction.setAmount(amount);
        transaction.setRemark(remark);
        transaction.setStatus(status);

        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findByAccountId(final Long id) {
        return transactionRepository.findTransactionsByAccountId(id);
    }
}
