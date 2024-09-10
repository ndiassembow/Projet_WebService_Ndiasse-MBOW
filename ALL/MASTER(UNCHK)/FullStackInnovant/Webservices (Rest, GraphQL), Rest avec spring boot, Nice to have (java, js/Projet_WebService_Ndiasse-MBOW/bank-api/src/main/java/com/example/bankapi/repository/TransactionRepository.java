package com.example.bankapi.repository;

import com.example.bankapi.model.Account;
import com.example.bankapi.model.Transaction;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount(Account account, Pageable pageable);
}
