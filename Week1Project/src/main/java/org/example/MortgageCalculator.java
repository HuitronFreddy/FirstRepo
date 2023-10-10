package org.example;

import java.util.Scanner;

import java.lang.Math;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //accept principal from user
        System.out.println("What is the principal loan amount: ");
        double principal = scanner.nextDouble();

        //accept interest rate from user
        System.out.println("What is the annual interest rate: ");
        double annualInterest = scanner.nextDouble();
        double monthlyInterest = (annualInterest / 12) / 100;


        //accept loan length from user
        System.out.println("What is the loan length in years: ");
        double loanLength = scanner.nextDouble();
        double monthlyLength = loanLength * 12;

        scanner.close();
        //math.pow(1 + monthlyInterest, monthlyLength) = a^b a = 1 + monthlyInterest, b= monthlyLength
        double monthlyPayment = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, monthlyLength))
                / (Math.pow(1 + monthlyInterest, monthlyLength) - 1);
        double totalInterest = (monthlyPayment * monthlyLength) - principal;

        System.out.printf("Monthly payments: $%.2f%n", monthlyPayment);
        System.out.printf("Total interest paid: $%.2f%n", totalInterest);

    }
}