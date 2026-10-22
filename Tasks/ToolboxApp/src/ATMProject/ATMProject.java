package ATMProject;

import java.util.Scanner;

public class ATMProject {

    static Scanner input = new Scanner(System.in);

    static double balance = 1000;
    static int pin = 1234;

    static int depositCount = 0;
    static double totalDeposits = 0;
    static double highestDeposit = 0;

    static int withdrawalCount = 0;
    static double totalWithdrawals = 0;
    static double highestWithdrawal = 0;

    static double totalTransfers = 0;
    static int transferCount = 0;

    static double totalWithdrawnThisSession = 0;

    static int SumArray(int[] arr){
        if ( login()){
            menu();
        }
        input.close();
    }
    // Login
    public static boolean login(){
        int attempts = 0;

        while ( attempts < 3 ){
            System.out.println("Enter the pin");

            if(!input.hasNextInt()){
                System.out.println("Invalid pin, Try again");
                input.next();
                attempts++;

                if( attempts < 3){
                    System.out.println("Attempts left : " + (3 - attempts));
                }
                else {
                    int enterPin = input.nextInt();

                    if ( enterPin == pin){
                        System.out.println("Welcome");
                        return true;
                    }
                    else {
                        attempts++;

                        if(attempts < 3){
                            System.out.println("wrong pin, Attempts left : " + (3 - attempts));
                        }
                    }
                }
            }
            System.out.println("Card blocked");
            return false;
        }

        // Main Menu
        int choice;

        do {
            System.out.println("ATM MENU ");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account tier");
            System.out.println("5. Savings projection");
            System.out.println("6. Receipt summary");
            System.out.println("7. Change PIN");
            System.out.println("8. Transfer money");
            System.out.println("0. Exit");
            System.out.print("Enter your choice : ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input, Please enter a number");
                input.next();
                System.out.print("Enter your choice : ");
            }

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    accountTier();
                    break;
                case 5:
                    savingsProjection();
                    break;
                case 6:
                    receiptSummary();
                    break;
                case 7:
                    changePin();
                    break;
                case 8:
                    transferMoney();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, Please try again");
            }
        }
        while (choice != 0);
    }
    // checkBalance
    public static void checkBalance(){
        System.out.println("current balance = " + balance);
    }

    // deposit
    public static void deposit(){
        System.out.println("Enter deposit amount : ");

        if(!input.hasNextDouble()){
            System.out.println("Invalid amount, Please enter a number");
            input.next();
            return;
        }
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Deposit must be greater than 0");
        } else if (amount > 5000) {
            System.out.println("Maximum deposit is 5000");
        } else {
            balance += amount;

            depositCount++;
            totalDeposits += amount;

            if (amount > highestDeposit) {
                highestDeposit = amount;
            }

            System.out.println("Deposit successful, Balance : " + balance);
        }
    }
}
