package com.bank.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import com.bank.service.model.Book;

@WebService
public interface BookService {

    @WebMethod
    double getBalance(String accountId);

    @WebMethod
    List<Book> getTransactions(String accountId, int pageNumber, int pageSize);

    @WebMethod
    void transferFunds(String creditor, String debtor, double amount, String currency);
}
