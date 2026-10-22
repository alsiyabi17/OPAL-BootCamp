package ArraysTask;

import java.util.Scanner;

public class ArraysTask {

    static Scanner input = new Scanner(System.in);

    // Question 1: Sum and Average
    static int SumArray(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i ++){
            sum = sum + arr[i];
        }
        return sum;
    }
    static double AvgArray(int[] arr){
        return (double) SumArray(arr) / arr.length;
    }



    public static void main(String[] args){

    }

    // Question 1: Sum and Average
}
