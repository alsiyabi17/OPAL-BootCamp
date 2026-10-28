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

        System.out.println("\nPaper 7: Hourglass");
        hourglass(n);

        System.out.println("\nPaper 8: Descending Alphabet Triangle");
        descendingAlphabet(n);

        System.out.println("\nPaper 9: Odd Number Triangle");
        oddNumberTriangle(n);

        System.out.println("\nPaper 10: Plus Sign");
        plusSign(n);
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
    }

    //Paper 2: Repeated Number Triangle


