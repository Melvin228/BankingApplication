package com.melvin.banking.controller;

import com.melvin.banking.common.dto.AccountDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final String HOME_PAGE = "home";
    private static final String BALANCE_INQUIRY_PAGE = "balanceInquiry";
    private static final String TRANSACTION_HISTORY_PAGE = "transactionHistory";
    private static final String DEPOSIT_PAGE = "deposit";
    private static final String WITHDRAWAL_PAGE = "withdrawal";
    private static final String TRANSFER_PAGE = "transfer";
    private static final String ACCOUNT_CREATION_PAGE = "createAccount";
    private static final String SUCCESS_PAGE = "success";
    private static final String FAIL_PAGE = "fail";

    @GetMapping(ReqMapping.View.LANDING)
    public String home() {
        return HOME_PAGE;
    }

    @GetMapping(ReqMapping.View.BALANCE_INQUIRY)
    public String balanceInquiry() {
        return BALANCE_INQUIRY_PAGE;
    }

    @GetMapping(ReqMapping.View.TRANSACTION_LISTING)
    public String transactionHistory() {
        return TRANSACTION_HISTORY_PAGE;
    }

    @GetMapping(ReqMapping.View.DEPOSIT)
    public String deposit() {
        return DEPOSIT_PAGE;
    }

    @GetMapping(ReqMapping.View.WITHDRAWAL)
    public String withdrawal() {
        return WITHDRAWAL_PAGE;
    }

    @GetMapping(ReqMapping.View.TRANSFER)
    public String transfer() {
        return TRANSFER_PAGE;
    }

    @GetMapping(ReqMapping.View.ACCOUNT_CREATION)
    public String accountCreation(Model model) {
        final String accountModel = "account";
        model.addAttribute(accountModel, new AccountDTO());
        return ACCOUNT_CREATION_PAGE;
    }

    @GetMapping(ReqMapping.View.SUCCESS)
    public String success() {
        return SUCCESS_PAGE;
    }

    @GetMapping(ReqMapping.View.FAIL)
    public String fail() {
        return FAIL_PAGE;
    }
}
