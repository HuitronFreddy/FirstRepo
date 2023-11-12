package org.example;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double calculateTotalPrice() {
        return getTotalPrice() + leaseFee + expectedEndingValue;
    }

    @Override
    public double calculateMonthlyPayment() {
        int loanTermMonths = 36;
        double annualInterestRate = 4.0;
        double monthlyInterestRate = annualInterestRate / 100 / 12;

        double basePrice = getTotalPrice();
        double totalLeaseAmount = basePrice + leaseFee;

        double monthlyPayment = totalLeaseAmount / loanTermMonths;

        return monthlyPayment;

    }
}
