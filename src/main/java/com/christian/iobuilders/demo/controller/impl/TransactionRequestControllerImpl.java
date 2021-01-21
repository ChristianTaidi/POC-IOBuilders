package com.christian.iobuilders.demo.controller.impl;

import com.christian.iobuilders.demo.controller.TransactionRequestController;
import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TransactionRequestControllerImpl implements TransactionRequestController {

    @Override
    @PostMapping(value = "/transact")
    public ResponseEntity performTransaction(@RequestBody Transaction transaction) {
        //ToDo input check
        //ToDo call credentials management service
        //Todo call transaction management service
        //ToDo return result
        return null;
    }

    @Override
    @PostMapping(value = "/addFunds", consumes = "application/json")
    public ResponseEntity addFunds(@RequestBody Transaction transaction) {
        //ToDo input check
        //ToDo call credentials management service
        //ToDo input check
        //        //ToDo call credentials management service
        //        //Todo call transaction management service
        //        //ToDo return result
        return null;
    }
}