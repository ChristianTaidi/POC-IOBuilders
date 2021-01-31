package com.christian.iobuilders.demo.service;

import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;

public interface TransactionService {

    Transaction transact(Long senderId, Transaction transaction);
    User addFunds(Long userId, Transaction transaction);
}
