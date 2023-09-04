package com.protonforest.samples.bankcheckingtransactions.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.protonforest.samples.bankcheckingtransactions.model.TransactionRequest;
import com.protonforest.samples.bankcheckingtransactions.model.TransactionResult;
import com.protonforest.samples.bankcheckingtransactions.service.TransactionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public TransactionResult postTransation(@RequestBody @Valid TransactionRequest request) {
        log.info("Endpoint hit.");
        transactionService.storeTransaction(request.getTransaction());
        return new TransactionResult("success");
    }
}
