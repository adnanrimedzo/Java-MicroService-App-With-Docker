package com.blueharvest.accoutservice.client;

import com.blueharvest.accoutservice.Document.Transaction;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("transaction-service")
public interface TransactionClient {

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{customer}")
    List<Transaction> findByCustomer(@PathVariable("customer") String customerId);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Transaction add(@RequestParam(value = "customerAccountId", required = true) String customerAccountId,
                    @RequestParam(value = "balance", required = true) int balance);

}
