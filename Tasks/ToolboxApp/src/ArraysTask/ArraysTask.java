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

    // Question 2: Largest and Smallest
    static int findMax(int[] arr){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++){
        if ( arr[i] > max){
            max = arr[i];
        }
        }
        return max;
    }

    static int findMin(int[] arr){
        int min = arr[0];

        for (int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }


    public static void main(String[] args){

    }

    // Question 1: Sum and Average
}
