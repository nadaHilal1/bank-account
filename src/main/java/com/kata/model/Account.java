package com.kata.model;

import java.util.ArrayList;
import java.util.List;


public class Account {

    private final String accountNumber;
    private final String clientName;
    private double balance;
    private List<AccountOperation> history;

    public Account(String accountNumber, double balance, String clientName) {
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccountOperation> getHistory() {
        return history;
    }

    public void setHistory(List<AccountOperation> history) {
        this.history = history;
    }
}
