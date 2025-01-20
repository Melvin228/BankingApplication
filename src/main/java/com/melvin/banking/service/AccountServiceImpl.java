package com.melvin.banking.service;

import com.melvin.banking.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final TransactionService transactionService;

    @Override
    public Account performDeposit(final Long id, final BigDecimal amount) {
        //transactionService.recordTransaction();
        return null;
    }

    @Override
    public Account performWithdrawal(final Long id, final BigDecimal amount) {
        return null;
    }

    @Override
    public Account performTransfer(final Long fromId, final Long toId, final BigDecimal amount) {
        return null;
    }

    @Override
    public Account createAccount() {
        return null;
    }
}
