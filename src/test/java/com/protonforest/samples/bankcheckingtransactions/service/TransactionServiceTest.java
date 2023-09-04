package com.protonforest.samples.bankcheckingtransactions.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.protonforest.samples.bankcheckingtransactions.model.Transaction;
import com.protonforest.samples.bankcheckingtransactions.repository.TransactionRepository;

@TestInstance(Lifecycle.PER_CLASS)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeAll
    public void setup() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionService(transactionRepository);
    }

    @Test
    void whenStoreTransaction_thenSuccess() {

        // doNothing().when(transactionRepository.save(any()));

        Transaction transaction = new Transaction();
        transactionService.storeTransaction(transaction);
        verify(transactionRepository, times(1));
    }
}
