package com.blueharvest.transactionservice.rest;

import com.blueharvest.transactionservice.Document.Transaction;
import com.blueharvest.transactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TransactionController {
    @Autowired
    TransactionRepository repository;

    protected Logger logger = Logger.getLogger(TransactionController.class.getName());

    @RequestMapping(value = "/customer/{customerAccountId}", method = RequestMethod.GET)
    public List findByCustomer(@PathVariable("customerAccountId") String customerId) {
        logger.info(String.format("Account.findByCustomer(%s)", customerId));
        return repository.findByCustomerAccountId(customerId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List findAll() {
        logger.info("Account.findAll()");
        return repository.findAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Transaction add(@RequestParam(value = "customerAccountId", required = true) String customerAccountId,
                           @RequestParam(value = "balance", required = true) int balance) {

        Transaction transaction = new Transaction();
        transaction.setCustomerId(customerAccountId);
        transaction.setBalance(balance);

        logger.info(String.format("Account.add(%s)", transaction));
        return repository.save(transaction);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Transaction update(@RequestBody Transaction transaction) {
        logger.info(String.format("Account.update(%s)", transaction));
        return repository.save(transaction);
    }
}