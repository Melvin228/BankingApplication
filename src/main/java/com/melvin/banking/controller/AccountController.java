package com.melvin.banking.controller;

import com.melvin.banking.model.Account;
import com.melvin.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/deposit/{accountId}")
    public final ResponseEntity<Account> deposit(@PathVariable final Long accountId, @RequestParam final BigDecimal amount) {
        Account account = accountService.performDeposit(accountId, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/withdraw/{accountId}")
    public final ResponseEntity<Account> withdraw(@PathVariable final Long accountId, @RequestParam final BigDecimal amount) {
        Account account = accountService.performWithdrawal(accountId, amount);
        return ResponseEntity.ok(account);
    }
}
