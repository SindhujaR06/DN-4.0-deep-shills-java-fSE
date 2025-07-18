package com.example.accountservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @GetMapping("/accounts")
    public List<String> getAccounts() {
        return List.of("Account1", "Account2", "Account3");
    }
}
