package ToolboxApp.src.CustomerFeedbackPortal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CustomerFeedbackPortal {

    static String[] names = new String[100];
    static int[] ratings = new int[100];
    static String[] comments = new String[100];
    static int count = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        loadFeedback();

        boolean running = true;
        while (running){
            showMenu();
            if(!input.hasNextLine()){
                break;;
            } try {
                int choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        addFeedback();
                        break;
                    case 2:
                        showAll();
                        break;;
                    case 3:
                        showAverage();
                        break;
                    case 4:
                        searchByRating();
                        break;
                    case 5:
                        deleteFeedback();
                        break;
                    case 6:
                        saveFeedback();
                        break;
                    case 7:
                        saveFeedback();
                        System.out.println("Goodbye...");
                        running = false;
                        break;
                    default:
                        System.out.println("Error , enter number between 1 - 7");
                }
            } catch (NumberFormatException e){
                System.out.println("Error , enter number between 1 - 7");
            }
        }
    }

    static void showMenu(){
        System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add feedback");
        System.out.println("2. Show all feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
        System.out.println("choose : ");
    }

    static void addFeedback(){
        if(count >= 100){
            System.out.println("The feedback list is full");
            return;;
        }
        String name ="";
        while (name.isEmpty()){
            System.out.println("Customer name : ");
            name = input.nextLine().trim().replace("|","-");
            if (name.isEmpty()){
                System.out.println("name can't be empty");
            }
        }
        int rating = 0;
        while (rating == 0){
            System.out.println("Rating should be 1 - 5");
            try{
                int number = Integer.parseInt(input.nextLine());
                if (number >= 1 && number <= 5 ){
                    rating = number;
                } else {
                    System.out.println("Rating should be 1 - 5");
                }
            } catch (NumberFormatException e){
                System.out.println("error, please enter a number");
            }
        }
        String comment = "";
        while (comment.isEmpty()){
            System.out.println("Comment : ");
            comment = input.nextLine().trim().replace("|","-");
            if (!comment.isEmpty()){
                System.out.println("Comment can't be empty");
            }
        }
        names[count] = name;
        ratings[count] = rating;
        comments[count] = comment;
        count++;

        System.out.println("Feedback added");
    }
    static void showAll() {
        if (count == 0) {
            System.out.println("No feedback");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - rating " + ratings[i] + " - " + comments[i]);
        }
    }
    static void showAverage() {
        if (count == 0) {
            System.out.println("No feedback");
            return;
        }

        int total = 0;
        for (int i = 0; i < count; i++) {
            total = total + ratings[i];
        }

        double average = (double) total / count;
        System.out.println("Average rating : " + average);
    }
    static void searchByRating() {
        System.out.print("Rating to search 1 - 5 ");
        try {
            int rating = Integer.parseInt(input.nextLine().trim());
            if (rating < 1 || rating > 5) {
                System.out.println("Rating must be between 1 and 5");
                return;
            }

            int found = 0;
            for (int i = 0; i < count; i++) {
                if (ratings[i] == rating) {
                    System.out.println((i + 1) + ". " + names[i] + " - rating " + ratings[i] + " - " + comments[i]);
                    found++;
                }
            }
            if (found == 0) {
                System.out.println("No feedback with rating " + rating);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter a number");
        }
    }
    static void deleteFeedback() {
        if (count == 0) {
            System.out.println("No feedback to delete");
            return;
        }
        showAll();
        System.out.print("Feedback number to delete: ");
        try {
            int number = Integer.parseInt(input.nextLine().trim());
            if (number < 1 || number > count) {
                System.out.println("Invalid feedback number");
                return;
            }

            int index = number - 1;
            for (int i = index; i < count - 1; i++) {
                names[i] = names[i + 1];
                ratings[i] = ratings[i + 1];
                comments[i] = comments[i + 1];
            }

            count--;
            names[count] = null;
            ratings[count] = 0;
            comments[count] = null;

            System.out.println("Feedback deleted");
        } catch (NumberFormatException e) {
            System.out.println("Error, please enter a number");
        }
    }
    static void saveFeedback() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }
            System.out.println("Feedback saved to feedback.txt");
        } catch (IOException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }
}
