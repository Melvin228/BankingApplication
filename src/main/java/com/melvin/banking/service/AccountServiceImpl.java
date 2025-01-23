package com.melvin.banking.service;

import com.melvin.banking.common.constants.Constants;
import com.melvin.banking.common.enums.TransactionStatus;
import com.melvin.banking.common.enums.TransactionType;
import com.melvin.banking.common.exception.InvalidAccountDetailsException;
import com.melvin.banking.common.exception.UserAlreadyExistsException;
import com.melvin.banking.model.Account;
import com.melvin.banking.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final TransactionService transactionService;
    private final UserService userService;
    private final AccountRepository accountRepository;

    @Transactional
    @Override
    public void performDeposit(final Long id, final BigDecimal amount) {
        validateAmount(amount);

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(Constants.ErrorMessage.ACCOUNT_NOT_FOUND));

        account.setBalance(account.getBalance().add(amount));
        accountRepository.save(account);
        transactionService.recordTransaction(null, account, TransactionType.DEPOSIT, TransactionStatus.SUCCESS, amount, String.format(Constants.Remark.PERFORMED_DEPOSIT, amount, account.getAccountNumber()));
    }

    @Transactional
    @Override
    public void performWithdrawal(final Long id, final BigDecimal amount) {
        validateAmount(amount);
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(Constants.ErrorMessage.ACCOUNT_NOT_FOUND));
        validateBalance(account, amount);

        account.setBalance(account.getBalance().subtract(amount));

        accountRepository.save(account);
        transactionService.recordTransaction(account, null, TransactionType.WITHDRAWAL, TransactionStatus.SUCCESS, amount, String.format(Constants.Remark.PERFORMED_WITHDRAWAL, amount, account.getAccountNumber()));
    }

    @Transactional
    @Override
    public void performTransfer(final Long fromId, final Long toId, final BigDecimal amount) {
        validateAmount(amount);

        // Fetch the accounts involved in the transfer
        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.ErrorMessage.FROM_ACCOUNT_NOT_FOUND));

        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.ErrorMessage.TO_ACCOUNT_NOT_FOUND));

        // Validate that the transfer is not happening to the same account
        if (fromAccount.getId().equals(toAccount.getId())) {
            throw new IllegalArgumentException(Constants.ErrorMessage.CANNOT_TRANSFER_SAME_ACC);
        }

        validateBalance(fromAccount, amount);

        // Perform the transfer
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        // Save the updated account balances
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        // Record the transaction
        String remark = String.format(Constants.Remark.PERFORMED_TRANSFER, amount, fromAccount.getAccountNumber(), toAccount.getAccountNumber());
        transactionService.recordTransaction(fromAccount, toAccount, TransactionType.TRANSFER, TransactionStatus.SUCCESS, amount, remark);
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

    @Override
    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAccountsByUserId(final Long userId) {
        return accountRepository.findByUserId(userId);
    }

    private boolean validateAccount(final Account account) {
        if (account == null) {
            throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_ACCOUNT_DETAILS);
        }
        return account.getAccountNumber().length() >= 10 && account.getAccountNumber().length() <= 16;
    }

    private void validateAmount(final BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(Constants.ErrorMessage.INVALID_AMOUNT);
        }
    }

    private void validateBalance(final Account account, BigDecimal amount) {
        // Validate if the account has enough balance for withdrawal
        if (account.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException(Constants.ErrorMessage.INSUFFICIENT_BALANCE);
        }
    }
}
