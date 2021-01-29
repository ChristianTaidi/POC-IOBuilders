package com.christian.iobuilders.demo.repository;

import com.christian.iobuilders.demo.pojos.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository realRepository;

    @Bean
    private TransactionRepository mockRepository(){
        return Mockito.mock(TransactionRepository.class);
    }

    TransactionRepository mockRepository = mockRepository();

    @Before
    public void init(){
        Transaction transaction = mockTransaction();
        transaction.setId(1L);
        when(mockRepository.findAll()).thenReturn(Arrays.asList(transaction));
        when(mockRepository.findById(1L)).thenReturn(Optional.of(transaction));
        when(mockRepository.save(any(Transaction.class))).thenReturn(transaction);
    }

    @Test
    public void it_should_save_the_Transaction(){
        Transaction transaction = mockTransaction();
        assertThat(mockRepository.save(transaction).getId()).isNotNull();
    }

    @Test
    public void it_should_find_the_Transaction_by_id(){
        Optional<Transaction> transaction = mockRepository.findById(1L);
        assertThat(transaction.get().getId()).isEqualTo(1L);
    }

    @Test
    public void it_should_return_all_Transactions_stored(){
        List<Transaction> transactions = mockRepository.findAll();
        assertThat(transactions.contains(Transaction.class));
        assertThat(transactions).isNotEmpty();
    }

    @Test
    public void it_should_save_data_in_real_repository(){
        Transaction transaction = mockTransaction();
        Assertions.assertNotNull(realRepository.save(transaction));
    }


    @Test
    public void it_should_find_by_id_in_real_repository(){
        Transaction transaction = mockTransaction();
        transaction = realRepository.save(transaction);

        assertThat(realRepository.findById(transaction.getId()).get()).isEqualTo(transaction);
    }

    private Transaction mockTransaction(){
        return new Transaction(1L,2L, 1);
    }

}
