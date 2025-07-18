package com.example.loanservice.service;

import com.example.loanservice.model.Loan;
import com.example.loanservice.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public Loan saveLoan(Loan loan) {
        return repository.save(loan);
    }

    public List<Loan> getLoans() {
        return repository.findAll();
    }
}
