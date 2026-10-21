
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
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or odd");
        System.out.println("3. Maximum of three numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication table");
        System.out.println("6. Triangle of stars");
        System.out.println("7. Prime check");
        System.out.println("8. Reverse a number");
        System.out.println("9. Number pyramid");
        System.out.println("0. Exit");
    }

    public static void celsiusToFahrenheit() {
        System.out.println("Please enter the temperature in Celsius: ");

        double c = inputObject.nextDouble();

        double Fahrenheit = (c * 9 / 5 + 32);

        System.out.println("Temperature in Fahrenheit " + Fahrenheit);
    }

    public static void evenOrOdd() {
        System.out.println("Enter a number : ");
        int num = inputObject.nextInt();

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

        int largest = first;

        if (second > largest) {
            largest = second;
        }

        if (third > largest) {
            largest = third;
        }

        System.out.println("The largest number is: " + largest);
    }

    public static void factorial() {

        System.out.println("Enter a number between 0-15 : ");
        int number = inputObject.nextInt();

        if (number < 0 || number > 15) {
            System.out.println("Number should be between 0 - 15");
            return;
        }

        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        System.out.println(number + "! = " + result);
    }

    public static void multiplicationTable() {

        System.out.println("Enter a number : ");
        int number = inputObject.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " X " + i + " = " + (number * i));
        }
    }

    public static void starTriangle() {
        System.out.println("Enter a number of rows : ");
        int rows = inputObject.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void isPrime() {
        System.out.println("Enter a number grater than 1  : ");
        int number = inputObject.nextInt();

        if (number <= 1) {
            System.out.println("Plese enter a number grater than 1 ");
            return;
        }

        boolean prime = true;
        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println("is Prime");
        } else {
            System.out.println("not Prime");
        }
    }

    public static void reverseNumber() {
        System.out.println("Enter a Positive number  : ");
        int number = inputObject.nextInt();

        if (number <= 0) {
            System.out.println("Plese Enter a Positive number : ");
            return;
        }

        int reverse = 0;
        while (number > 0) {
            int x = number % 10;
            reverse = reverse * 10 + x;
            number = number / 10;
        }

        System.out.println("Reversed number : " + reverse);
    }

    public static void numberPyramid() {
        System.out.println("Enter number of rows : ");
        int rows = inputObject.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (j < i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
