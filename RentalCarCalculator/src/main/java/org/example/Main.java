

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What day would you like to pickup the car?");

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        System.out.println("How many days will you be renting the vehicle? (Whole numbers!");
        double daysRented = scanner.nextDouble();
        double basicCarRental = daysRented * 29.99;

        System.out.println("Enter your age (Whole Numbers Only!).");
        double userAge = scanner.nextDouble();
        double surcharge = 0;
        if (userAge < 25) {
            surcharge = daysRented * 29.99 * .3;
        } else {
            surcharge = daysRented * 0;
        }
        scanner.nextLine();
        System.out.println("Would you like an Electronic toll tag at $3.95/day? (yes/no)");
        String wantsToll = scanner.nextLine();
        double tollCost = 0;
        if (wantsToll.equalsIgnoreCase("yes")) {
            tollCost = daysRented * 3.95;
        }

        System.out.println("Would you like a GPS at $2.95/day? (yes/no)");
        String wantsGps = scanner.nextLine();
        double gpsCost = 0;

        if (wantsGps.equalsIgnoreCase("yes")) {
            gpsCost = daysRented * 2.95;
        }

        System.out.println("Would you like roadside assistance at $3.95/day? (yes/no)");
        String wantsRoadSide = scanner.nextLine();
        double roadSideCost = 0;
        if (wantsRoadSide.equalsIgnoreCase("yes")) {
            roadSideCost = daysRented * 3.95;
        }

        double totalOptionsCost = optionsCost(tollCost, gpsCost, roadSideCost);
        double totalCost = basicCarRental + totalOptionsCost + surcharge;

        System.out.printf("Basic car rental: %.2f%n", basicCarRental);

        System.out.printf("Options cost: %.2f%n", totalOptionsCost);

        System.out.printf("Underage driver surcharge: %.2f%n", surcharge);

        System.out.printf("Total Cost: %.2f%n", totalCost);

        System.out.println("The basic car rental is $29.99 per day. There is a 30% surcharge on the basic car rental for drivers under 25. All Taxes have already been incorporated into the fees shown.");

    }
    public static double optionsCost(double tollCost, double gpsCost, double roadSideCost) {
        return tollCost + gpsCost + roadSideCost;
    }
}
