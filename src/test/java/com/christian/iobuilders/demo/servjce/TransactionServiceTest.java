package com.christian.iobuilders.demo.servjce;

import com.christian.iobuilders.demo.pojos.Transaction;
import com.christian.iobuilders.demo.pojos.User;
import com.christian.iobuilders.demo.service.TransactionService;
import com.christian.iobuilders.demo.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.InvalidParameterException;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;

    @Autowired
    UserService userService;

    Transaction transaction;

    @Before
    public void init() {
        transaction = mockTransaction();
    }


    @Test
    public void test_transactServiceInits() {
        assertThat(transactionService).isNotNull();
    }

    @Test
    public void whenTransactionRegistered_thenIDIsGenerated() {

        if (transaction != null) {
            Transaction transaction = transactionService.transact(this.transaction.getSenderId(), this.transaction);
            assertThat(transaction).extracting(Transaction::getId).isNotEmpty();
        }
    }

    @Test
    public void whenTransactionIsNull_thenErrorIsReturned() {

        Transaction transaction = null;
        assertThatThrownBy(() -> {
            transactionService.transact(null, transaction);

        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining("Null transaction");

    }

    @Test
    public void whenSenderIdIsNull_thenErrorIsReturned() {

        transaction.setSenderId(null);
        assertThatThrownBy(() -> {
            transactionService.transact(transaction.getSenderId(), transaction);

        }).isInstanceOf(InvalidDataAccessApiUsageException.class)
                .hasMessageContaining("The given id must not be null!");

    }

    @Test
    public void whenTransactionAmountIsWrong_thenErrorIsReturned() {

        User finalUser = userService.getById(transaction.getSenderId());
        transaction.setAmount(30);
        assertThatThrownBy(() -> {
            transactionService.transact(finalUser.getId(), transaction);

        }).isInstanceOf(InvalidParameterException.class)
                .hasMessageContaining("Invalid sender data");

    }

    @Test
    public void whenAddFunds_thenUserBalanceIncreases() {

        int currentBalance = userService.getById(transaction.getSenderId()).getBalance();
        Transaction addFunds = new Transaction(transaction.getSenderId(),10);
        User user = transactionService.addFunds(addFunds.getSenderId(),addFunds);

        assertThat(user.getBalance()).isGreaterThan(currentBalance);

    }

    private Transaction mockTransaction() {
        User user = new User("12345678A", "test", "test@mail.com", "password");
        user.setBalance(20);
        userService.saveUser(user);
        return new Transaction(user.getId(),2L,20);
    }
}