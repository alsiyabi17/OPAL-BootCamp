package ToolboxApp.src.JavaPatternPapers;

import java.util.Scanner;

public class JavaPatternPapers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println("\nPaper 1: Hollow Square");
        hollowSquare(n);

        System.out.println("\nPaper 2: Repeated Number Triangle");
        repeatedNumberTriangle(n);

        System.out.println("\nPaper 3: Reverse Number Triangle");
        reverseNumberTriangle(n);

        System.out.println("\nPaper 4: Full Diamond");
        fullDiamond(n);

        System.out.println("\nPaper 5: Hollow Diamond");
        hollowDiamond(n);

        System.out.println("\nPaper 6: X Pattern");
        xPattern(n);

//        System.out.println("\nPaper 7: Hourglass");
//        hourglass(n);
//
//        System.out.println("\nPaper 8: Descending Alphabet Triangle");
//        descendingAlphabet(n);
//
//        System.out.println("\nPaper 9: Odd Number Triangle");
//        oddNumberTriangle(n);
//
//        System.out.println("\nPaper 10: Plus Sign");
//        plusSign(n);
    }

    //Paper 1: Hollow Square
    static void hollowSquare(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //Paper 2: Repeated Number Triangle
    static void repeatedNumberTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Paper 3: Reverse Number Triangle
    static void reverseNumberTriangle(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    // Paper 4: Full Diamond
    static void fullDiamond(int n) {
        for (int i = 1; i <= 5; i++) {
            for (int k = 4; k >= i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int k = 4; k >= i; k--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Paper 5: Hollow Diamond
    static void hollowDiamond(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int k = (i <= n) ? i : 2 * n - i;   // row size: 1..n..1

            for (int s = 0; s < n - k; s++) System.out.print(" ");
            System.out.print("*");
            if (k > 1) {
                for (int s = 0; s < 2 * k - 3; s++) System.out.print(" ");
                System.out.print("*");
            }
            System.out.println();
        }
    }
    // Paper 6: X Pattern
    static void xPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i + j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}



