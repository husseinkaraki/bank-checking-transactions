package com.protonforest.samples.bankcheckingtransactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    @Valid
    @NotNull(message = "Property 'transaction' is required")
    Transaction transaction;
}
