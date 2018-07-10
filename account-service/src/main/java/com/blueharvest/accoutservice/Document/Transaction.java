package com.blueharvest.accoutservice.Document;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@ApiModel
public class Transaction {

    @Id
    private String id;
    private String customerAccountId;
    private int balance;

    @ApiModelProperty(position = 1, required = true)
    public String getCustomerAccountId() {
        return customerAccountId;
    }

    public void setCustomerAccountId(String customerAccountId) {
        this.customerAccountId = customerAccountId;
    }

    @ApiModelProperty(position = 2, required = true)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
