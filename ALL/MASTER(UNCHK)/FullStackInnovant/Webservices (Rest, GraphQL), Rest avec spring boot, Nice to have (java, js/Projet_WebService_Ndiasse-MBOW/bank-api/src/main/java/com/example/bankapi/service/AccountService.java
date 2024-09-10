package com.example.bankapi.service;

import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import com.example.bankapi.repository.AccountRepository;
import com.example.bankapi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public double getBalance(String accountId) {
        Account account = accountRepository.findByAccountId(accountId);
        return account != null ? account.getBalance() : 0;
    }

    public List<Transaction> getTransactions(String accountId, int page, int size) {
        Account account = accountRepository.findByAccountId(accountId);
        Pageable pageable = PageRequest.of(page, size);
        return transactionRepository.findByAccount(account, pageable);
    }

    public String transfer(String sourceAccountId, String targetAccountId, double amount) {
        Account sourceAccount = accountRepository.findByAccountId(sourceAccountId);
        Account targetAccount = accountRepository.findByAccountId(targetAccountId);

        if (sourceAccount == null || targetAccount == null) {
            return "Invalid account";
        }

        if (sourceAccount.getBalance() < amount) {
            return "Insufficient funds";
        }

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        Transaction transaction = new Transaction();
        transaction.setAccount(sourceAccount);
        transaction.setAmount(-amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setDescription("Transfer to " + targetAccountId);
        transactionRepository.save(transaction);

        transaction = new Transaction();
        transaction.setAccount(targetAccount);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setDescription("Transfer from " + sourceAccountId);
        transactionRepository.save(transaction);

        return "Transfer successful";
    }
}
