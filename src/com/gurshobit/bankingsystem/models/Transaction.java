package com.gurshobit.bankingsystem.models;

import java.util.concurrent.atomic.AtomicLong;

public class Transaction {
    private static final AtomicLong count = new AtomicLong(1);
    private long id;
    private String accountNumber;
    private Boolean transactionType;
    private double amount;
    private double openingBalance;
    private double closingBalance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Boolean getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Boolean transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public double getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(double closingBalance) {
        this.closingBalance = closingBalance;
    }

    @Override
    public String toString() {
        return "Transaction "+id+" {" +
                "openingBalance=" + openingBalance +
                ", Type=" + ((transactionType) ? "Debit":"Credit") +
                ", amount=" + amount +
                ", closingBalance=" + closingBalance +
                '}';
    }
}
