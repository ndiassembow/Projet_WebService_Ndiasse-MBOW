package com.example.bankapi.controller;

import com.example.bankapi.model.Transaction;
import com.example.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.getBalance(accountId));
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountId,
                                                              @RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(accountService.getTransactions(accountId, page, size));
    }

    @PostMapping("/{accountId}/transfer")
    public ResponseEntity<String> transfer(@PathVariable String accountId,
                                            @RequestParam String targetAccountId,
                                            @RequestParam double amount) {
        return ResponseEntity.ok(accountService.transfer(accountId, targetAccountId, amount));
    }
}
