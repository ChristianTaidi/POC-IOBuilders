package com.christian.iobuilders.demo.controller;

import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import org.springframework.http.ResponseEntity;

public interface TransactionRequestController {

    ResponseEntity performTransaction(Transaction transaction);
    ResponseEntity addFunds(Transaction transaction);
}
