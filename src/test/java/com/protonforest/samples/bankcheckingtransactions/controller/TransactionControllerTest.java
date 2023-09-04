package com.protonforest.samples.bankcheckingtransactions.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.protonforest.samples.bankcheckingtransactions.model.Transaction;
import com.protonforest.samples.bankcheckingtransactions.model.TransactionRequest;
import com.protonforest.samples.bankcheckingtransactions.service.TransactionService;

@TestInstance(Lifecycle.PER_CLASS)
@WebMvcTest(controllers = TransactionController.class)
@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    TransactionController controller;

    @MockBean
    TransactionService transactionService;

    private ObjectMapper objectMapper;

    @BeforeAll
    void setup(@Mock TransactionService transactionService) {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    }

    @Test
    void whenPostTransaction_thenSuccess() throws Exception {
        Transaction transaction = new Transaction(123, 123, new Date().from(Instant.now()) );
        TransactionRequest request = new TransactionRequest(transaction);
        mockMvc.perform(post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("message").value("success"));
    }

    @Test
    void whenPostTranaction_andAmountValidationViolation_thenReturn400_andCustomResponse() throws Exception {
        
        Transaction transaction = new Transaction(123, 123, new Date().from(Instant.now()) );
        transaction.setAmount(null);
        TransactionRequest request = new TransactionRequest(transaction);
        mockMvc.perform(post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().is4xxClientError(),
                        jsonPath("$.errors[0].fieldName").value("transaction.amount"),
                        jsonPath("$.errors[0].message").value("must not be null"));
    }

    @Test
    void whenPostTranaction_andCheckingAccountIdValidationViolation_thenReturn400_andCustomResponse() throws Exception {
        
        Transaction transaction = new Transaction(123, 123, new Date().from(Instant.now()) );
        transaction.setCheckingAccountId(null);
        TransactionRequest request = new TransactionRequest(transaction);
        mockMvc.perform(post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().is4xxClientError(),
                        jsonPath("$.errors[0].fieldName").value("transaction.checkingAccountId"),
                        jsonPath("$.errors[0].message").value("must not be null"));
    }

    @Test
    void whenPostTranaction_andCreatedAtValidationViolation_thenReturn400_andCustomResponse() throws Exception {
        
        Transaction transaction = new Transaction(123, 123, new Date().from(Instant.now()) );
        transaction.setCreatedAt(null);
        TransactionRequest request = new TransactionRequest(transaction);
        mockMvc.perform(post("/transaction")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request))
                .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(
                        status().is4xxClientError(),
                        jsonPath("$.errors[0].fieldName").value("transaction.createdAt"),
                        jsonPath("$.errors[0].message").value("must not be null"));
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
