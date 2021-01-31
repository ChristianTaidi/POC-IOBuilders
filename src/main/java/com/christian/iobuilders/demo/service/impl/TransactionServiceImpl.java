package com.christian.iobuilders.demo.service.impl;

import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.repository.TransactionRepository;
import com.christian.iobuilders.demo.service.TransactionService;
import com.christian.iobuilders.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactions;

    @Autowired
    private UserService userService;

    @Override
    public Transaction transact(Long senderId, Transaction transaction) {

        User user = userService.getById(senderId);
        /**
         * If user exists and have enough money, perform the transaction
         */
        if(user!=null && user.getBalance()>transaction.getAmount()) {

            User receiver = userService.getById(transaction.getReceiverId());
            /**
             * If receiver exists, perform transaction
             */
            if(receiver!=null){
                receiver.setBalance(receiver.getBalance()+transaction.getAmount());
                user.setBalance(user.getBalance()-transaction.getAmount());
                transactions.save(transaction);
                userService.saveUser(user);
                userService.saveUser(receiver);
                return transaction;
            }else{
                throw new InvalidParameterException("Receiver is null");
            }

        }else{
            throw new InvalidParameterException("Invalid sender data");
        }

    }

    @Override
    public User addFunds(Long userId, Transaction transaction) {
        return null;
    }
}
