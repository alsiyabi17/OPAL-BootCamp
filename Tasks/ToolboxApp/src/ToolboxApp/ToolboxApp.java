package ToolboxApp;

import java.util.Scanner;

public class ToolboxApp {

    static Scanner inputObject = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            menu();
            System.out.println("Enter number between 0-9");

            while (!inputObject.hasNextInt()) {
                System.out.println("Invaild number, please neter number between 0 -9");
                inputObject.next();
            }
            choice = inputObject.nextInt();

            switch (choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                    maxOfThree();
                    break;
                case 4:
                    factorial();
                    break;
                case 5:
                    multiplicationTable();
                    break;
                case 6:
                    starTriangle();
                    break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                    numberPyramid();
                    break;
                case 0:
                    System.out.println("Good bye...");
                    break;
                default:
                    System.out.println("Invaild number, please neter number between 0 -9");
            }
            System.out.println();

        } while (choice != 0);
        inputObject.close();
    }

    public static void menu() {
        System.out.println("Celsius to Fahrenheit");
        System.out.println("Even or odd");
        System.out.println("Maximum of three numbers");
        System.out.println("Factorial");
        System.out.println("Multiplication table");
        System.out.println("Triangle of stars");
        System.out.println("Prime check");
        System.out.println("Reverse a number");
        System.out.println("Number pyramid");
        System.out.println("Exit");
    }

    public static void celsiusToFahrenheit() {
        double c = 0;

        Scanner tempObject = new Scanner(System.in);

        System.out.print("Please enter the temperature in Celsius: ");
        String userInputTemp = tempObject.nextLine();

        tempObject.close();

        c = Double.parseDouble(userInputTemp);

        //C to F
        double Fahrenheit = (c * 9 / 5 + 32);

        System.out.println("Temperature in Fahrenheit " + Fahrenheit);
    }

    public static void evenOrOdd() {
        int num = 0;
        Scanner number = new Scanner(System.in);
        System.out.println("Enter a number : ");
        String UserInput = number.nextLine();
        number.close();
        num = Integer.parseInt(UserInput);
        if (num % 2 == 0) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

    }

    public static void maxOfThree() {
        System.out.println("Enter three numbers : ");
        int first = inputObject.nextInt();
        int second = inputObject.nextInt();
        int third = inputObject.nextInt();

        if (first > second && first > third) {
            System.out.println("First is largest");
        } else if (second > first && second > third) {
            System.out.println("Second is largest");
        } else if (third > first && third > second) {
            System.out.println("Third is largest");
        }
    }

    public static void factorial() {

        System.out.println("Enter a number between 0-15 : ");
        int number = inputObject.nextInt();

        if (number < 0 || number > 15) {
            System.out.println("Number should be between 0 - 15");
            return;
            ;
        }
        int result = 1;
        for (i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println(number + "! = " + result);
    }

    public static void multiplicationTable(){

        System.out.println("Enter a number : ");
        int number = inputObject.nextInt();

        for ( int i = 1; i <= 10; i++){
            System.out.println(number + " X " + i + " = " + (number * i));
        }
    }

    public static void starTriangle(){
        System.out.println("Enter a number of rows : ");
        int rows = inputObject.nextInt();

        for (int i = 1; i <= rows; i++){
            for ( int j = 1; j <= i; j++){
                System.out.println("* ");
            }
            System.out.println();
        }
    }

    public static void isPrime(){

    }

    public static void reverseNumber(){

    }

    public static void numberPyramid(){

    }
}
