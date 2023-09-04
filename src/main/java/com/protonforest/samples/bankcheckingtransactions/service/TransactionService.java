package com.protonforest.samples.bankcheckingtransactions.service;

import org.springframework.stereotype.Service;

import com.protonforest.samples.bankcheckingtransactions.model.Transaction;
import com.protonforest.samples.bankcheckingtransactions.repository.TransactionEntity;
import com.protonforest.samples.bankcheckingtransactions.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    public void storeTransaction(Transaction transaction) {
        TransactionEntity transactionEntity = buildEntity(transaction);
        log.info("Persisting entity with transactionId : " + transactionEntity.getTransactionId());
        transactionRepository.save(transactionEntity);
    }

    private TransactionEntity buildEntity(Transaction transaction) {
        return TransactionEntity.builder()
        .checkingAccountId(transaction.getCheckingAccountId())
        .amount(transaction.getAmount())
        .createdAt(transaction.getCreatedAt())
        .build();
    }
    
}
