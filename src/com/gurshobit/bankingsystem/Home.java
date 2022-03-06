package com.gurshobit.bankingsystem;

import com.gurshobit.bankingsystem.data.CustomersDatabase;
import com.gurshobit.bankingsystem.models.Customer;
import com.gurshobit.bankingsystem.services.BankingOperations;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Scanner;

public class Home {
    public static int userChoice = 0;
    public static CustomersDatabase customersDatabase = new CustomersDatabase();
    public static Scanner scannerInput = new Scanner(System.in);
    public static HashMap <String, Customer> customerHashMap = customersDatabase.customersList();
    public static String userAccountNumber,userAccountPassword;
    public static Customer loggedInCustomer;
    public static BankingOperations bankingOperations = new BankingOperations();
    public static int userMenuChoice = 0;

    public static void main(String[] args) {

        System.out.println("Welcome to Small Bank!");
        System.out.println("----------------------");
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Login ");
            System.out.println("2. Exit");
            userMenuChoice = Integer.parseInt(scannerInput.nextLine());
            if(userMenuChoice == 1){
                auth();
            }
        } while(userMenuChoice != 2);

    }

    public static void auth(){
        System.out.println("Please Enter Your Account number:");
        userAccountNumber = scannerInput.nextLine();
        System.out.println("Please Enter Your Account Password:");
        userAccountPassword = scannerInput.nextLine();

        loggedInCustomer = customerHashMap.get(userAccountNumber);
        if(loggedInCustomer != null && userAccountPassword.equals(loggedInCustomer.getPassword())){
            homeMenu();
        } else{
            System.out.println("Invalid Account Information");
            auth();
        }
    }

    public static void homeMenu(){
        do {
            System.out.println("----------------------");
            System.out.println("Hello, "+loggedInCustomer.getAccountHolderName()+"!");
            System.out.println("----------------------");
            System.out.println("Select from Options Below:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdrawal");
            System.out.println("4. Transfer");
            System.out.println("5. Logout");
            userChoice = Integer.parseInt(scannerInput.nextLine());

            switch (userChoice){
                case 1:
                    System.out.println("Your Account Balance is Rs. "+loggedInCustomer.getBalanceAmount());
                    goToMenuConfirmation();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit into your account "+loggedInCustomer.getAccountNumber()+": ");
                    try {
                        double depositAmount = Double.parseDouble(scannerInput.nextLine());
                        Boolean operationStatus = bankingOperations.deposit(depositAmount,loggedInCustomer);
                        if(operationStatus){
                            customerHashMap.replace(userAccountNumber,loggedInCustomer);
                        }
                    } catch (Exception e){
                        System.out.println("Invalid Amount");
                    }
                    goToMenuConfirmation();
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw from your account "+loggedInCustomer.getAccountNumber()+": ");
                    try {
                        double depositAmount = Double.parseDouble(scannerInput.nextLine());
                        Boolean  operationStatus = bankingOperations.withdrawal(depositAmount,loggedInCustomer);
                        if(operationStatus){
                            customerHashMap.replace(userAccountNumber,loggedInCustomer);
                        }
                    } catch (Exception e){
                        System.out.println("Invalid Amount");
                    }
                    goToMenuConfirmation();
                    break;
                case 4:
                    System.out.println("Enter the account number you want to transfer funds: ");
                    String otherUserAccountNumber = scannerInput.nextLine();
                    Customer otherCustomer = customerHashMap.get(otherUserAccountNumber);
                    if(otherCustomer == null){
                        System.out.println("Invalid Customer Account Number");
                    } else {
                        System.out.println("Enter the amount you want to transfer to "+otherCustomer.getAccountHolderName()+": ");
                        try {
                            double transferAmount = Double.parseDouble(scannerInput.nextLine());
                            Long generatedOtp = bankingOperations.generateOtp();
                            System.out.println("OTP generated for transaction is "+generatedOtp);
                            Long otpInput;
                            Boolean firstExecution = true;
                            do {
                                if(!firstExecution){
                                    System.out.println("Invalid OTP!");
                                }
                                if(firstExecution){
                                    firstExecution = false;
                                }
                                System.out.println("Enter OTP for transaction: ");
                                otpInput = Long.parseLong(scannerInput.nextLine());
                            } while(!generatedOtp.toString().equals(otpInput.toString()));

                            Boolean operationStatus = bankingOperations.transfer(transferAmount,loggedInCustomer,otherCustomer);
                            if(operationStatus){
                                customerHashMap.replace(userAccountNumber,loggedInCustomer);
                                customerHashMap.replace(otherUserAccountNumber,otherCustomer);
                            }
                        } catch (Exception e){
                            System.out.println("Invalid Amount");
                        }
                    }
                    goToMenuConfirmation();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!!");
                    break;
                default:
                    break;
            }

        } while (userChoice != 5);
    }

    public static void goToMenuConfirmation(){
        System.out.println("Do you want to goto homepage (1. Yes/2. No)?");
        int userInput = Integer.parseInt(scannerInput.nextLine());
        if(userInput == 1){
            homeMenu();
        } else{
            System.out.println("Thank you for banking with us!!");
            System.exit(0);
        }
    }

}
