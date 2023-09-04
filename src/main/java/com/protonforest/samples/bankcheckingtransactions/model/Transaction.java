package com.protonforest.samples.bankcheckingtransactions.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Transaction {

    @NotNull
    Integer checkingAccountId;
    
    @NotNull
    Integer amount;
    
    @NotNull
    Date createdAt;
}
