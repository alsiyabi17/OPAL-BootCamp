package ToolboxApp.src.TryCatch;

import java.io.*;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        WriteFile();
        ReadFile();
        CopyFile();
    }

    private static void WriteFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
            Scanner input = new Scanner(System.in);

            System.out.println("Enter text to write inside the text file");

            String text = input.nextLine();
            writer.write(text);
            writer.close();

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void ReadFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void CopyFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copy.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("File copied");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}