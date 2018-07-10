package com.blueharvest.accoutservice.repository;

import com.blueharvest.accoutservice.Document.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
public interface AccountRepository extends MongoRepository<Account, String> {
    public List<Account> findByCustomerId(String customerId);
}
