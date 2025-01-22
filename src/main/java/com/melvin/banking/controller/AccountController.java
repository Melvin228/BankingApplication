package com.melvin.banking.controller;

import com.melvin.banking.common.dto.AccountDTO;
import com.melvin.banking.model.Account;
import com.melvin.banking.service.AccountManager;
import com.melvin.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping(ReqMapping.Accounts.BASE_URI)
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AccountManager accountManager;

    @PostMapping(ReqMapping.Accounts.CREATE_ACCOUNT)
    public String createAccount(@ModelAttribute("account") final AccountDTO accountDTO) {
        final Account account = accountManager.convertToEntity(accountDTO);
        accountService.createAccount(account);
        return "redirect:/success"; // or redirect to a success page
    }

    @PostMapping(ReqMapping.Accounts.DEPOSIT_BY_ACCOUNTID)
    public final ResponseEntity<Account> deposit(@PathVariable final Long accountId, @RequestParam final BigDecimal amount) {
        final Account account = accountService.performDeposit(accountId, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping(ReqMapping.Accounts.WITHDRAW_BY_ACCOUNTID)
    public final ResponseEntity<Account> withdraw(@PathVariable final Long accountId, @RequestParam final BigDecimal amount) {
        final Account account = accountService.performWithdrawal(accountId, amount);
        return ResponseEntity.ok(account);
    }
}
