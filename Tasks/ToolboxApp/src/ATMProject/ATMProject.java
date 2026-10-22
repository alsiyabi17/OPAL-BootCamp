
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

    public static void main(String[] args) {
        if (login()) {
            menu();
        }
        input.close();
    }

    // Login
    public static boolean login() {
        int attempts = 0;

        while (attempts < 3) {
            System.out.println("Enter the pin");

            if (!input.hasNextInt()) {
                System.out.println("Invalid pin, Try again");
                input.next();
                attempts++;
            } else {
                int enterPin = input.nextInt();

                if (enterPin == pin) {
                    System.out.println("Welcome");
                    return true;
                } else {
                    attempts++;
                    System.out.println("wrong pin, Attempts left : "
                            + (3 - attempts));
                }
            }

            if (attempts < 3) {
                System.out.println("Attempts left : " + (3 - attempts));
            }
        }

        System.out.println("Card blocked");
        return false;
    }

    // Main Menu
    public static void menu() {
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
        } while (choice != 0);
    }

    // checkBalance
    public static void checkBalance() {
        System.out.printf("current balance = %.2f%n", balance);
    }

    // deposit
    public static void deposit() {
        System.out.println("Enter deposit amount : ");

        if (!input.hasNextDouble()) {
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

            System.out.printf("Deposit successful, Balance : %.2f%n", balance);
        }
    }

    // withdraw
    public static void withdraw() {
        System.out.println("Enter withdrawal amount");

        if (!input.hasNextDouble()) {
            System.out.println("Invalid amount, Please enter a number");
            input.next();
            return;
        }

        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal must be greater than 0");
            return;
        }

        if (amount % 10 != 0) {
            System.out.println("Withdrawal must be a multiple of 10");
            return;
        }

        if (totalWithdrawnThisSession + amount > 1000) {
            System.out.println("Session withdrawal limit is 1000");
            return;
        }

        double fee = calculateFee(amount);

        System.out.printf("Fee : %.2f%n", fee);

        if (balance < amount + fee) {
            System.out.println("Insufficient balance to cover the "
                    + "withdrawal and fee.");
        } else {
            balance -= amount + fee;

            withdrawalCount++;
            totalWithdrawals += amount;
            totalWithdrawnThisSession += amount;

            if (amount > highestWithdrawal) {
                highestWithdrawal = amount;
            }

            System.out.printf("Withdrawal successful, Balance : %.2f%n",
                    balance);
        }
    }

    // Calculate withdrawal or transfer fee
    public static double calculateFee(double amount) {
        if (amount <= 500) {
            return 2.00;
        } else {
            return 5.00;
        }
    }

    // Option 4: Account Tier
    public static void accountTier() {
        if (balance < 1000) {
            System.out.println("Tier : Bronze, interest rate : 1%");
        } else if (balance < 5000) {
            System.out.println("Tier : Silver, interest rate : 2%");
        } else if (balance < 20000) {
            System.out.println("Tier : Gold, interest rate : 3%");
        } else {
            System.out.println("Tier : Platinum, interest rate : 4%");
        }
    }

    // Option 5: Savings Projection
    public static void savingsProjection() {
        System.out.println("Enter number of years : ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid input, Please enter a whole number");
            input.next();
            return;
        }

        int years = input.nextInt();

        if (years < 1 || years > 10) {
            System.out.println("Years must be between 1 - 10");
            return;
        }

        double interestRate;

        if (balance < 1000) {
            interestRate = 0.01;
        }
        else if (balance < 5000) {
            interestRate = 0.02;
        }
        else if (balance < 20000) {
            interestRate = 0.03;
        }
        else {
            interestRate = 0.04;
        }

        double projectedBalance = balance;

        for (int year = 1; year <= years; year++) {
            projectedBalance *= (1 + interestRate);

            System.out.printf("Year : %d %.2f%n", year, projectedBalance);
        }
    }

    // Option 6: Receipt Summary
    public static void receiptSummary() {
        System.out.println("Deposits : " + depositCount);
        System.out.printf("total : %.2f%n", totalDeposits);

        System.out.println("Withdrawals: " + withdrawalCount);
        System.out.printf(" total : %.2f%n", totalWithdrawals);

        System.out.println("Transfers : " + transferCount);
        System.out.printf("total : %.2f%n", totalTransfers);

        System.out.printf("Balance : %.2f%n", balance);
        System.out.printf("Highest deposit : %.2f%n", highestDeposit);
        System.out.printf("Highest withdrawal : %.2f%n", highestWithdrawal);
    }

    // Option 7: Change PIN
    public static void changePin() {
        System.out.println("Enter old PIN");

        if (!input.hasNextInt()) {
            System.out.println("Invalid PIN");
            input.next();
            return;
        }

        int oldPin = input.nextInt();

        if (oldPin != pin) {
            System.out.println("Incorrect old PIN");
            return;
        }

        System.out.println("Enter new 4-digit PIN");

        if (!input.hasNextInt()) {
            System.out.println("PIN must contain exactly 4 digits");
            input.next();
            return;
        }

        int newPin = input.nextInt();

        if (newPin < 1000 || newPin > 9999) {
            System.out.println("PIN must be between 1000 and 9999");
            return;
        }

        System.out.println("Confirm new PIN");

        if (!input.hasNextInt()) {
            System.out.println("PIN confirmation must be numeric");
            input.next();
            return;
        }

        int confirmPin = input.nextInt();

        if (newPin == confirmPin) {
            pin = newPin;
            System.out.println("PIN changed successfully");
        } else {
            System.out.println("PINs do not match, PIN unchanged");
        }
    }

    // Bonus : Transfer Money
    public static void transferMoney() {
        System.out.println("Enter 6-digit account number");

        if (!input.hasNextLong()) {
            System.out.println("Invalid account number");
            input.next();
            return;
        }

        long accountNumber = input.nextLong();

        if (accountNumber < 100000 || accountNumber > 999999) {
            System.out.println("Account number must have 6 digits");
            return;
        }

        System.out.println("Enter transfer amount");

        if (!input.hasNextDouble()) {
            System.out.println("Invalid amount, Please enter a number");
            input.next();
            return;
        }

        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Transfer amount must be greater than 0");
            return;
        }

        double fee = calculateFee(amount);

        System.out.printf("Fee : %.2f%n", fee);

        if (balance < amount + fee) {
            System.out.println("Insufficient balance to cover the transfer and fee");
        } else {
            balance -= amount + fee;
            transferCount++;
            totalTransfers += amount;
            System.out.println("Transfer successful to account : " + accountNumber);
            System.out.printf("Balance : %.2f%n", balance);
        }
    }
}
