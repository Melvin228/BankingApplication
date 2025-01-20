package com.melvin.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {
    private static final String HEALTHCHECK_PAGE = "health";

    @GetMapping(ReqMapping.HealthCheck.BASE_URI)
    public String checkHealth(final Model model) {
        model.addAttribute("message", "Application is up and running");
        return HEALTHCHECK_PAGE;
    }
}
