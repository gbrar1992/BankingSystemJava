package com.gurshobit.bankingsystem.services;

import com.gurshobit.bankingsystem.models.Customer;
import com.gurshobit.bankingsystem.models.Transaction;

import java.util.ArrayList;

public class BankingOperations {
    public boolean deposit(double amount, Customer customer){
        if(amount > 0){
            double openingBalance = customer.getBalanceAmount();
            double closingBalance = openingBalance + amount;
            customer.setBalanceAmount(closingBalance);
            performTransaction(amount, customer, openingBalance, closingBalance, false);
            System.out.println("Amount Successfully Deposited. Current Balance is Rs. " +customer.getBalanceAmount());
            return true;
        } else {
            System.out.println("Invalid Amount");
            return false;
        }
    }

    public boolean withdrawal(double amount, Customer customer){
        if(amount > 0){
            if(customer.getBalanceAmount() >= amount){
                double openingBalance = customer.getBalanceAmount();
                double closingBalance = openingBalance - amount;
                customer.setBalanceAmount(closingBalance);
                performTransaction(amount, customer, openingBalance,closingBalance, true);
                System.out.println("Amount Withdrawal Successful. Balance is Rs. " +customer.getBalanceAmount());


                return true;
            } else {
                System.out.println("Low Balance");
                return false;
            }

        } else {
            System.out.println("Invalid Amount");
            return false;
        }
    }

    public boolean transfer (double amount, Customer customerFrom, Customer customerTo){
        if(amount > 0){
            if(customerFrom.getBalanceAmount() >= amount){
                // Customer From
                double openingBalanceCustomerFrom = customerFrom.getBalanceAmount();
                double closingBalanceCustomerFrom = openingBalanceCustomerFrom - amount;
                customerFrom.setBalanceAmount(closingBalanceCustomerFrom);

                performTransaction(amount, customerFrom, openingBalanceCustomerFrom,closingBalanceCustomerFrom, true);
                // Customer To
                double openingBalanceCustomerTo = customerTo.getBalanceAmount();
                double closingBalanceCustomerTo = openingBalanceCustomerTo + amount;
                customerTo.setBalanceAmount(closingBalanceCustomerTo);

                performTransaction(amount, customerTo, openingBalanceCustomerTo,closingBalanceCustomerTo, false);

                System.out.println("Amount Transfer Successful.");
                System.out.println("Amount of Rs. "+amount+" is transferred to "+customerTo.getAccountHolderName());


                return true;
            } else {
                System.out.println("Low Balance");
                return false;
            }

        } else {
            System.out.println("Invalid Amount");
            return false;
        }
    }

    public void performTransaction(double amount, Customer customer, double openingBalance, double closingBalance, boolean transactionType) {
        ArrayList<Transaction> customerTransactions = customer.getTransactions();
        Transaction transaction = new Transaction();
        transaction.setId(customerTransactions.size() + 1);
        transaction.setAmount(amount);
        transaction.setAccountNumber(customer.getAccountNumber());
        transaction.setTransactionType(transactionType);
        transaction.setOpeningBalance(openingBalance);
        transaction.setClosingBalance(closingBalance);
        customerTransactions.add(transaction);

        customer.setTransactions(new ArrayList<>());
        customer.setTransactions(customerTransactions);
    }

    public long generateOtp(){
        return (long) (Math.random() * 99999 + 100000);
    }

}
