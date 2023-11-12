package org.example;

import java.util.List;

class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = getTotalPrice();
        double totalPrice = basePrice + salesTaxAmount + recordingFee + processingFee;
        setTotalPrice(totalPrice);
        return getTotalPrice();
    }

    @Override
    public double calculateMonthlyPayment() {
        if (financeOption) {
            //? 48 : 24; this piece of code sets interest rate and loan term if total price is less than 10k
            double loanInterestRate = getTotalPrice() >= 10000 ? 0.0425 : 0.0525;
            int loanTerm = getTotalPrice() >= 10000 ? 48 : 24;

            double monthlyInterestRate = loanInterestRate / 12;
            double loanAmount = getTotalPrice();
            //loan payment formula
            double monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));

            setMonthlyPayment(monthlyPayment);
            return monthlyPayment;
        } else {
            setMonthlyPayment(0);
            return 0;
        }
    }
}

