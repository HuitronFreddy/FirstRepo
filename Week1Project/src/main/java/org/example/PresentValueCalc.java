package org.example;

import java.util.Scanner;

public class PresentValueCalc {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //accept monthly payment amount
        System.out.println("What is the monthly payment amount?: ");
        double monthlyPaymentAmount = scanner.nextDouble();

        //accept annual interest and convert to monthly
        System.out.println("What is the annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        double monthlyInterestRate = annualInterestRate / 12 / 100;

        //accept number of years to pay out
        System.out.println("What is the number of years to pay out?: ");
        double yearsToPayOut = scanner.nextDouble();
        double monthlyPayments = yearsToPayOut * 12;

        double presentValue = calculatePresentValue(monthlyPaymentAmount, monthlyInterestRate, monthlyPayments);

        System.out.printf("The present value of the annuity is: $%.2f", presentValue);
    }
    public static double calculatePresentValue(double monthlyPaymentAmount, double monthlyInterestRate, double monthlyPayments){
        if (monthlyInterestRate == 0) {
            return monthlyPaymentAmount + (monthlyPaymentAmount * monthlyPayments);
        }
        return monthlyPaymentAmount * (1 - Math.pow(1 + monthlyInterestRate, -monthlyPayments)) / monthlyInterestRate;
    }
}
