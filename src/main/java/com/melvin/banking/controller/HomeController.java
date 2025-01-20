package com.melvin.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final String HOME_PAGE = "home";
    private static final String BALANCE_INQUIRY_PAGE = "balanceInquiry";

    @GetMapping("/")
    public String home() {
        return HOME_PAGE;
    }

    @GetMapping("/balance")
    public String balanceInquiry() {
        return BALANCE_INQUIRY_PAGE;
    }
}
