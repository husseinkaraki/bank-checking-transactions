package com.protonforest.samples.bankcheckingtransactions.repository;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

}
