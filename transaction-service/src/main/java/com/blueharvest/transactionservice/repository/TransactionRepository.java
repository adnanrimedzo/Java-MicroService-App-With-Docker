package com.blueharvest.transactionservice.repository;

import com.blueharvest.transactionservice.Document.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    public List<Transaction> findByCustomerAccountId(String customerId);
}
