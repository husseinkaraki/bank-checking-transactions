package com.protonforest.samples.bankcheckingtransactions.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.protonforest.samples.bankcheckingtransactions.model.PostTransactionRequest;
import com.protonforest.samples.bankcheckingtransactions.model.PostTransactionResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TransactionController {

    @PostMapping("/transaction")
    public PostTransactionResult postTransation(@RequestBody PostTransactionRequest request) {
        log.info("Endpoint hit.");
        return new PostTransactionResult("success");
    }
}
