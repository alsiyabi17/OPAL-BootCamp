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

        
    }
}
