package org.example;

import java.util.Scanner;

public class FutureValueCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //accept initial deposit
        System.out.println("What is the initial deposit value: ");
        double initialDeposit = scanner.nextDouble();

        //accept annual interest rate and convert to daily interest rate
        System.out.println("What is the annual interest rate of your item: ");
        double annualInterestRate = scanner.nextDouble();
        double dailyInterestRate = annualInterestRate / 365;

        //accept user input for years
        System.out.println("How many years would the item appreciate by: ");
        double yearsInFuture = scanner.nextDouble();

        double futureValue = calculateFutureValue(initialDeposit, dailyInterestRate, yearsInFuture);
        double totalInterest = futureValue - initialDeposit;

        System.out.printf("The future value of the item is: $%.2f%n", futureValue);
        System.out.printf("The total interest earned is: $%.2f%n", totalInterest);
    }
    public static double calculateFutureValue(double initialDeposit, double dailyInterestRate, double yearsinFuture){
        if (dailyInterestRate == 0) {
            return initialDeposit + (initialDeposit * yearsinFuture);
        }
        return initialDeposit * Math.pow(1 + (dailyInterestRate / 100), 365 * yearsinFuture);
    }
}
