package com.bank.ws;

import javax.xml.ws.Endpoint;
import com.bank.service.BookServiceImpl;

public class BankServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/ws/bank", new BookServiceImpl());
    }
}
