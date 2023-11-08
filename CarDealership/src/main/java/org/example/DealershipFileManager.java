package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    private static final String VEHICLES_FILE_PATH = "src/main/resources/Vehicles.csv";

    public static Dealership getDealership() {
        //If you're adding the vehicle to the dealerships list of vehicles
        //Why do you need the variable 'vehicleList'?
        List<Vehicle> vehicleList = new ArrayList<>();
        Dealership dealership = new Dealership(); // Create a new Dealership object

        try {
            try (FileInputStream fileInputStream = new FileInputStream(VEHICLES_FILE_PATH);
                 Scanner scanner = new Scanner(fileInputStream)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] vehicle = line.split(",");
                    if (vehicle.length == 8) {
                        int vin = Integer.parseInt(vehicle[0]);
                        int year = Integer.parseInt(vehicle[1]);
                        String make = vehicle[2];
                        String model = vehicle[3];
                        String vehicleType = vehicle[4];
                        String color = vehicle[5];
                        int odometer = Integer.parseInt(vehicle[6]);
                        double price = Double.parseDouble(vehicle[7]);

                        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                        //What does adding the car to this list actually do?
                        vehicleList.add(newVehicle);

                        dealership.addVehicle(newVehicle);
                    } else {
                        System.out.println("Invalid data in the file: " + VEHICLES_FILE_PATH);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("File not found: " + VEHICLES_FILE_PATH);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid data format in the file: " + VEHICLES_FILE_PATH);
        }

        return dealership;
    }
}