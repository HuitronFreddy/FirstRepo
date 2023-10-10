package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your numerical score: ");
        int userScore = scanner.nextInt();

        if (userScore >= 90) {
            System.out.println("Letter grade is A");
        }
        else if (userScore >= 80 && userScore <= 89) {
            System.out.println("Letter grade is B");
        }
        else if (userScore >= 70 && userScore <= 79) {
                System.out.println("Letter grade is C");
        }
        else if (userScore >= 60 && userScore <= 69) {
            System.out.println("Letter grade is D");
        }
        else {
            System.out.println("Letter grade is F");
        }

        scanner.close();

    }
}