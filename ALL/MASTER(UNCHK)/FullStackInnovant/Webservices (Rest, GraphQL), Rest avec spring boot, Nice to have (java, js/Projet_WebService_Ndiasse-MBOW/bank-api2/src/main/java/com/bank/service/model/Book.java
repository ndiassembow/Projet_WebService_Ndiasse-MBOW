package com.bank.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
    private String title;
    private String author;
    private String category;
    private boolean isBestSeller;
    private int year;

    // Getters and Setters
}
