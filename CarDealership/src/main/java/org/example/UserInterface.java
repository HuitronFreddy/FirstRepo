package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;
    public Dealership getDealership() {
        return dealership;
    }
    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        boolean isMakingSelection = true;

        while (isMakingSelection) {
            System.out.println("Welcome to the Dealership Application Menu.");
            System.out.println("1 - Find vehicles within a price range.");
            System.out.println("2 - Find vehicles by make/model.");
            System.out.println("3 - Find vehicles by year range.");
            System.out.println("4 - Find vehicles by color.");
            System.out.println("5 - Find vehicles by mileage range.");
            System.out.println("6 - Find vehicles by type (car, truck, SUV, van).");
            System.out.println("7 - List ALL vehicles.");
            System.out.println("8 - Add a vehicle.");
            System.out.println("9 - Remove a vehicle.");
            System.out.println("0 - Quit.");
            System.out.println("Please enter a number: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processFilterByPrice();
                    break;
                case 2:
                    processFilterByMakeModel();
                    break;
                case 3:
                    processFilterByYear();
                    break;
                case 4:
                    processFilterByColor();
                    break;
                case 5:
                    processFilterByMileage();
                    break;
                case 6:
                    processFilterByVehicleType();
                    break;
                case 7:
                    processListAllVehicles();
                    break;
                case 8:
                    processAddVehicle();
                    break;
                case 9:
                    processRemoveVehicle();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select a valid choice.");
            }
        }
    }

    private void processFilterByPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> filteredVehicles = dealership.getVehicleByPrice(minPrice, maxPrice);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByMakeModel() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByMake(make, model);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();

        List<Vehicle> filteredVehicles = dealership.getVehicleByYear(minYear, maxYear);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByColor(color);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByMileage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.print("Enter maximum mileage: ");
        double maxMileage = scanner.nextDouble();

        List<Vehicle> filteredVehicles = dealership.getVehicleByMileage(minMileage, maxMileage);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processFilterByVehicleType() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.next();

        List<Vehicle> filteredVehicles = dealership.getVehicleByType(vehicleType);

        displayFilteredVehicles(filteredVehicles);
    }

    private void processListAllVehicles() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayFilteredVehicles(allVehicles);
    }

    private void processAddVehicle() {
        System.out.println("Please enter the following information.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        System.out.print("Enter the vehicle's year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the vehicle's make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the vehicle's model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the vehicle type (car, truck, SUV, van): ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter the vehicle's color: ");
        String color = scanner.nextLine();
        System.out.print("Enter the vehicle's odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter the vehicle's price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("New vehicle added successfully.\n");
    }

    private void processRemoveVehicle() {
        System.out.println("Please enter the VIN of the vehicle you want to remove:");
        Scanner scanner = new Scanner(System.in);
        int vinToRemove = scanner.nextInt();

        List<Vehicle> inventory = dealership.getAllVehicles();
        boolean removed = false;

        for (Vehicle vehicle : inventory) {
            if (vehicle.getVin() == vinToRemove) {
                dealership.removeVehicle(vehicle);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Vehicle with VIN " + vinToRemove + " has been removed from the inventory.\n");
        } else {
            System.out.println("No vehicle found with VIN " + vinToRemove + " in the inventory.\n");
        }
    }

    private void displayFilteredVehicles(List<Vehicle> filteredVehicles) {
        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("Filtered Vehicles:");
            for (Vehicle vehicle : filteredVehicles) {
                System.out.println(vehicle);
            }
        }
    }
}
