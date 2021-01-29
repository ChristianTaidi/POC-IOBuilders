package com.christian.iobuilders.demo.controller.impl;

import com.christian.iobuilders.demo.controller.TransactionRequestController;
import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.TransactionService;
import com.christian.iobuilders.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TransactionRequestControllerImpl implements TransactionRequestController {

    @Autowired
    private TransactionService transService;

    @Autowired
    private UserService userService;


    @Override
    @PostMapping(value = "/transact/{id}")
    public ResponseEntity performTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {

        transService.transact(id,transaction);


        return null;
    }

    @Override
    @PostMapping(value = "/addFunds/{id}", consumes = "application/json")
    public ResponseEntity addFunds(@PathVariable Long id,@RequestBody Transaction transaction) {
        //ToDo input check
        //ToDo call credentials management service
        //ToDo input check
        //        //ToDo call credentials management service
        //        //Todo call transaction management service
        //        //ToDo return result
        return null;
    }

    @Override
    @GetMapping(value = "/users")
    public ResponseEntity getUsers() {
        List users = userService.getAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }
}