package com.kata.model;

import java.time.LocalDateTime;


public class AccountOperation {

    private final OperationType operationType;
    private final double amount;
    private final LocalDateTime date;

    public AccountOperation(OperationType operationType, double amount) {

        this.operationType = operationType;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String toString() {
        return "Operation: " + this.operationType +
                " " + "Solde" + this.amount +
                " " + "Date" + this.date;
    }
}
