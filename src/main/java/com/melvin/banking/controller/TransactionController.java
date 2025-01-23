package com.melvin.banking.controller;

import com.melvin.banking.model.Transaction;
import com.melvin.banking.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(ReqMapping.Transaction.BASE_URI)
public class TransactionController {
    private static final String TRANSACTION_HISTORY_PAGE = "transactionHistory";
    private static final String TRANSACTIONS_MODEL = "transactions";
    private final TransactionService transactionService;

    @GetMapping(ReqMapping.Transaction.TRANSACTION_LISTING)
    public String transactionHistory(@PathVariable final Long accountId, final Model model) {
        List<Transaction> transactions = transactionService.findByAccountId(accountId);
        model.addAttribute(TRANSACTIONS_MODEL, transactions);
        return TRANSACTION_HISTORY_PAGE;
    }
}
