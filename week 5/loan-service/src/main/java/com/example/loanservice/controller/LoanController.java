
package com.example.loanservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @GetMapping("/loans")
    public List<String> getLoans() {
        return List.of("Loan1", "Loan2", "Loan3");
    }
}

