package com.christian.iobuilders.demo.controller;

import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface TransactionRequestController {

    ResponseEntity getUsers();

    ResponseEntity performTransaction(@PathVariable Long id, @RequestBody Transaction transaction);

    ResponseEntity addFunds(Long id, Transaction transaction);
}
