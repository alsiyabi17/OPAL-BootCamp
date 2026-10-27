package ToolboxApp.src.CustomerFeedbackPortal;

import java.io.BufferedReader;
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

}
