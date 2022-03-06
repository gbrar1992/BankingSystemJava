package com.gurshobit.bankingsystem.data;

import com.gurshobit.bankingsystem.models.Customer;

import java.util.HashMap;

public class CustomersDatabase {
    public HashMap<String, Customer> customersList() {
        long customerAccountNumber = 100001;

        Customer customerOne = new Customer();
        customerOne.setAccountNumber("" + customerAccountNumber++);
        customerOne.setAccountHolderName("Ram");
        customerOne.setPassword("123456789");

        Customer customerTwo = new Customer();
        customerTwo.setAccountNumber("" + customerAccountNumber++);
        customerTwo.setAccountHolderName("Sham");
        customerTwo.setPassword("123456789");

        Customer customerThree = new Customer();
        customerThree.setAccountNumber("" + customerAccountNumber++);
        customerThree.setAccountHolderName("Mohan");
        customerThree.setPassword("123456789");

        Customer customerFour = new Customer();
        customerFour.setAccountNumber("" + customerAccountNumber++);
        customerFour.setAccountHolderName("Sita");
        customerFour.setPassword("123456789");

        Customer customerFive = new Customer();
        customerFive.setAccountNumber("" + customerAccountNumber++);
        customerFive.setAccountHolderName("Radha");
        customerFive.setPassword("123456789");

        HashMap <String,Customer> customerMap = new HashMap<>();
        customerMap.put(customerOne.getAccountNumber(),customerOne);
        customerMap.put(customerTwo.getAccountNumber(),customerTwo);
        customerMap.put(customerThree.getAccountNumber(),customerThree);
        customerMap.put(customerFour.getAccountNumber(),customerFour);
        customerMap.put(customerFive.getAccountNumber(),customerFive);
        return customerMap;
    }
}
