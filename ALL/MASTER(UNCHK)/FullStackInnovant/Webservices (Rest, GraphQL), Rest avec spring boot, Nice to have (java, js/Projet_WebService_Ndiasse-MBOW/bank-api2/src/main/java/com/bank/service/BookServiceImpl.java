package com.bank.service;

import com.bank.service.model.Book;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.bank.service.BookService")
public class BookServiceImpl implements BookService {

    @Override
    public double getBalance(String accountId) {
        // Implémentation de la consultation du solde
    }

    @Override
    public List<Book> getTransactions(String accountId, int pageNumber, int pageSize) {
        // Implémentation de la récupération des transactions avec pagination
    }

    @Override
    public void transferFunds(String creditor, String debtor, double amount, String currency) {
        // Implémentation du virement
    }
}
