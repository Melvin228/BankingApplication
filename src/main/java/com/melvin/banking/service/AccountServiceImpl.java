package com.melvin.banking.service;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.common.exception.InvalidAccountDetailsException;
import com.melvin.banking.common.exception.UserAlreadyExistsException;
import com.melvin.banking.model.Account;
import com.melvin.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final TransactionService transactionService;
    private final UserService userService;
    private final AccountRepository accountRepository;

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
    public Account createAccount(final Account account) {
        if (userService.validateUser(account.getUser())) {
            throw new UserAlreadyExistsException(Constants.ErrorMessage.USER_ALREADY_EXISTS);
        }
        if (!validateAccount(account)) {
            throw new InvalidAccountDetailsException(Constants.ErrorMessage.INVALID_ACCOUNT_NUMBER);
        }
        return accountRepository.save(account);
    }

    private boolean validateAccount(final Account account) {
        if (account == null) {
            throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_ACCOUNT_DETAILS);
        }
        return account.getAccountNumber().length() >= 10 && account.getAccountNumber().length() <= 16;
    }
}
