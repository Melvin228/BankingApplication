package com.melvin.banking.controller;

import com.melvin.banking.common.dto.AccountDTO;
import com.melvin.banking.common.model.CustomUser;
import com.melvin.banking.security.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static final String HOME_PAGE = "home";
    private static final String ACCOUNT_CREATION_PAGE = "createAccount";
    private static final String SUCCESS_PAGE = "success";
    private static final String FAIL_PAGE = "fail";

    @GetMapping(ReqMapping.View.LANDING)
    public String home(final Model model) {
        final CustomUser user = SecurityUtils.getCurrentUserDetailsSafely();
        model.addAttribute("user", user);
        return HOME_PAGE;
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
