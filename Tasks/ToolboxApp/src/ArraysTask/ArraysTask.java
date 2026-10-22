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

    // Question 5: Student Grades
    static int[] readGrades(int size){
        int[] grades = new int[size];

        for (int i = 0; i < grades.length; i++){
            System.out.println("Enter grade " + (i+1));
            grades[i] = input.nextInt();

            while (grades[i] < 0 || grades[i] > 100){
                System.out.println("Plese enter number between 0 - 100");
                grades[i] = input.nextInt();
            }
        }
        return grades;
    }

    static int countPassed(int[] grades){
        int count = 0;
        for (int i =0; i < grades.length; i++){
            if (grades[i] >= 50){
                count++;
            }
        }
        return count;
    }


    // Bonus
    static int secondLargest(int[] arr){
        int largest = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;

        for ( int i =0 ; i < arr.length; i++){
            if ( arr[i] > largest){
                second = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > second){
                second = arr[i];
            }
        }
        return second;
    }


    public static void main(String[] args){

    }
    
}
