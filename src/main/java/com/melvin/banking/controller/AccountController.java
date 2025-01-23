package com.melvin.banking.controller;

import com.melvin.banking.common.dto.AccountDTO;
import com.melvin.banking.common.dto.TransactionDTO;
import com.melvin.banking.common.dto.TransferDTO;
import com.melvin.banking.common.mapper.AccountMapper;
import com.melvin.banking.common.model.CustomUser;
import com.melvin.banking.model.Account;
import com.melvin.banking.security.SecurityUtils;
import com.melvin.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ReqMapping.Accounts.BASE_URI)
@RequiredArgsConstructor
public class AccountController {
    private static final String BALANCE_INQUIRY_PAGE = "balanceInquiry";
    private static final String ACCOUNT_MODEL = "accounts";
    private static final String TRANSACTION_DTO_MODEL = "transactiondto";
    private static final String TRANSFER_DTO_MODEL = "transferdto";
    private static final String DEPOSIT_PAGE = "deposit";
    private static final String WITHDRAWAL_PAGE = "withdrawal";
    private static final String TRANSFER_PAGE = "transfer";
    private static final String REDIRECT_TO_SUCCESS = "redirect:/success";

    private final AccountService accountService;

    @GetMapping(ReqMapping.Accounts.BALANCE_INQUIRY)
    public String balanceInquiry(final Model model) {
        final CustomUser user = SecurityUtils.getCurrentUserDetailsSafely();
        model.addAttribute(ACCOUNT_MODEL, accountService.findAccountsByUserId(user.getId()));
        return BALANCE_INQUIRY_PAGE;
    }

    @GetMapping(ReqMapping.Accounts.DEPOSIT)
    public String deposit(Model model) {
        final CustomUser user = SecurityUtils.getCurrentUserDetailsSafely();
        model.addAttribute(ACCOUNT_MODEL, accountService.findAccountsByUserId(user.getId()));
        model.addAttribute(TRANSACTION_DTO_MODEL, new TransactionDTO());

        return DEPOSIT_PAGE;
    }

    @GetMapping(ReqMapping.Accounts.WITHDRAWAL)
    public String withdrawal(Model model) {
        final CustomUser user = SecurityUtils.getCurrentUserDetailsSafely();
        model.addAttribute(ACCOUNT_MODEL, accountService.findAccountsByUserId(user.getId()));
        model.addAttribute(TRANSACTION_DTO_MODEL, new TransactionDTO());

        return WITHDRAWAL_PAGE;
    }

    @GetMapping(ReqMapping.Accounts.TRANSFER)
    public String transfer(Model model) {
        final CustomUser user = SecurityUtils.getCurrentUserDetailsSafely();
        model.addAttribute(ACCOUNT_MODEL, accountService.findAccountsByUserId(user.getId()));
        model.addAttribute(TRANSFER_DTO_MODEL, new TransferDTO());
        return TRANSFER_PAGE;
    }

    @PostMapping(ReqMapping.Accounts.CREATE_ACCOUNT)
    public String createAccount(@ModelAttribute("account") final AccountDTO accountDTO) {
        final Account account = AccountMapper.convertToEntity(accountDTO);
        accountService.createAccount(account);
        return REDIRECT_TO_SUCCESS;
    }

    @PostMapping(ReqMapping.Accounts.DEPOSIT)
    public final String performDeposit(@ModelAttribute final TransactionDTO transaction) {
        accountService.performDeposit(transaction.getAccountId(), transaction.getAmount());
        return REDIRECT_TO_SUCCESS;
    }

    @PostMapping(ReqMapping.Accounts.WITHDRAWAL)
    public final String performWithdrawal(@ModelAttribute final TransactionDTO transaction) {
        accountService.performWithdrawal(transaction.getAccountId(), transaction.getAmount());
        return REDIRECT_TO_SUCCESS;
    }

    @PostMapping(ReqMapping.Accounts.TRANSFER)
    public final String performTransfer(@ModelAttribute final TransferDTO transfer) {
        accountService.performTransfer(transfer.getFromAccountId(), transfer.getToAccountId(), transfer.getAmount());
        return REDIRECT_TO_SUCCESS;
    }
}
