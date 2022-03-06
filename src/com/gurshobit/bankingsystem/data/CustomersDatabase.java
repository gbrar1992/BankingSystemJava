package com.gurshobit.bankingsystem.data;

import com.gurshobit.bankingsystem.models.Customer;
import com.gurshobit.bankingsystem.models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomersDatabase {
    public HashMap<String, Customer> customersList() {
//        long customerAccountNumber = 100001;

        Customer customerOne = new Customer();
        customerOne.setAccountNumber("");
        customerOne.setAccountHolderName("Ram");
        customerOne.setPassword("123456789");
        customerOne.setTransactions(new ArrayList<Transaction>());

        Customer customerTwo = new Customer();
        customerTwo.setAccountNumber("");
        customerTwo.setAccountHolderName("Sham");
        customerTwo.setPassword("123456789");
        customerTwo.setTransactions(new ArrayList<Transaction>());

        Customer customerThree = new Customer();
        customerThree.setAccountNumber("");
        customerThree.setAccountHolderName("Mohan");
        customerThree.setPassword("123456789");
        customerThree.setTransactions(new ArrayList<Transaction>());

        Customer customerFour = new Customer();
        customerFour.setAccountNumber("");
        customerFour.setAccountHolderName("Sita");
        customerFour.setPassword("123456789");
        customerFour.setTransactions(new ArrayList<Transaction>());

        Customer customerFive = new Customer();
        customerFive.setAccountNumber("");
        customerFive.setAccountHolderName("Radha");
        customerFive.setPassword("123456789");
        customerFive.setTransactions(new ArrayList<Transaction>());

        HashMap <String,Customer> customerMap = new HashMap<>();
        customerMap.put(customerOne.getAccountNumber(),customerOne);
        customerMap.put(customerTwo.getAccountNumber(),customerTwo);
        customerMap.put(customerThree.getAccountNumber(),customerThree);
        customerMap.put(customerFour.getAccountNumber(),customerFour);
        customerMap.put(customerFive.getAccountNumber(),customerFive);
        return customerMap;
    }
}
