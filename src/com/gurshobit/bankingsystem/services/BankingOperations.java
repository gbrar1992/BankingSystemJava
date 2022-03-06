package com.gurshobit.bankingsystem.services;

import com.gurshobit.bankingsystem.models.Customer;

public class BankingOperations {
    public boolean deposit(double amount, Customer customer){
        if(amount > 0){
            customer.setBalanceAmount(customer.getBalanceAmount() + amount);
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
                customer.setBalanceAmount(customer.getBalanceAmount() - amount);
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
                customerFrom.setBalanceAmount(customerFrom.getBalanceAmount() - amount);
                customerTo.setBalanceAmount(customerTo.getBalanceAmount() + amount);
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

    public long generateOtp(){
        return (long) (Math.random() * 99999 + 100000);
    }

}
