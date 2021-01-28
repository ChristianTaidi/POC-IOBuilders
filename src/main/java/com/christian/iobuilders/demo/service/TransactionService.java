package com.christian.iobuilders.demo.service;

import com.christian.iobuilders.demo.pojos.Transaction;

public interface TransactionService {

    String transact(Long senderId, Transaction transaction);
}
