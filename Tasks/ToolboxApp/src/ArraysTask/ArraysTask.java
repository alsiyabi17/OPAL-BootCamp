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

    // Question 3: Count and Search
    static int countEven(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 == 0){
                count++;
            }
        }
        return count;
    }

    static int indexOf(int[] arr, int target){
        for ( int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    // Question 4: Reverse the Array
    static int[] reverseArray(int[] arr){
        int[] reversed = new int[arr.length];

        for ( int i =0; i < arr.length; i++){
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    static void printArray(int[] arr){
        for ( int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){

    }

    // Question 1: Sum and Average
}
