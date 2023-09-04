package com.protonforest.samples.bankcheckingtransactions.repository;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "transactions")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    private Integer checkingAccountId;
    private Integer amount;
    private Date createdAt;

}