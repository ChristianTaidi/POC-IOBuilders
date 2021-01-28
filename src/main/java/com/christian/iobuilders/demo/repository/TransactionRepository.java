package com.christian.iobuilders.demo.repository;

import com.christian.iobuilders.demo.pojos.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAll();
}
