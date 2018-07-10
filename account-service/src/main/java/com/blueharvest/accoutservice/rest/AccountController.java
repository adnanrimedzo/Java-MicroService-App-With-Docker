package com.blueharvest.accoutservice.rest;

import com.blueharvest.accoutservice.Document.Account;
import com.blueharvest.accoutservice.Document.Transaction;
import com.blueharvest.accoutservice.client.TransactionClient;
import com.blueharvest.accoutservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class AccountController {
    @Autowired
    AccountRepository repository;

    @Autowired
    private TransactionClient transactionClient;

    protected Logger logger = Logger.getLogger(AccountController.class.getName());

    @RequestMapping(value = "/customer/{customer}", method = RequestMethod.GET)
    public List findByCustomer(@PathVariable("customer") String customerId) {
        logger.info(String.format("Account.findByCustomer(%s)", customerId));
        List<Account> accounts = repository.findByCustomerId(customerId);
        accounts.stream().forEach(a -> {
            a.setTransactions(transactionClient.findByCustomer(a.getId()));
        });
        return accounts;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List findAll() {
        logger.info("Account.findAll()");
        List<Account> accounts = repository.findAll();
        accounts.stream().forEach(a -> {
            a.setTransactions(transactionClient.findByCustomer(a.getId()));
        });
        return accounts;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Account add(@RequestParam(value = "customer", required = true) String customerId,
                       @RequestParam(value = "balance", required = true) int balance,
                       @RequestParam(value = "firstName", required = true) String firstName,
                       @RequestParam(value = "surname", required = true) String surname) {

        Account account = new Account();
        account.setCustomerId(customerId);
        account.setFirstName(firstName);
        account.setSurname(surname);
        account.setBalance(balance);

        logger.info(String.format("Account.add(%s)", account));
        account = repository.save(account);
        if (account.getBalance() != 0) {
            transactionClient.add(account.getId(),account.getBalance());
        }
        return account;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Account update(@RequestBody Account account) {
        logger.info(String.format("Account.update(%s)", account));
        return repository.save(account);
    }
}