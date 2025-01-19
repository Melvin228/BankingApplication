package com.melvin.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthCheckController {
    @GetMapping("/health")
    public String checkHealth(final Model model) {
        model.addAttribute("message", "Application is up and running");
        return "health";
    }
}
