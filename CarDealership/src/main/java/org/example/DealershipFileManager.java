package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {
    //assigning vehicle inventory to VEHICLES_FILE_PATH
    private static final Path VEHICLES_FILE_PATH = Paths.get("src", "main", "resources", "Vehicles.csv");

    public static Dealership getDealership() {
        List<Vehicle> vehicleList = new ArrayList<>();
        Dealership dealership = new Dealership("Huitron Dealership", "1234 St ave", "222-777-8888");

        try (FileInputStream fileInputStream = new FileInputStream(VEHICLES_FILE_PATH.toFile());
             Scanner scanner = new Scanner(fileInputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    if (line.equalsIgnoreCase("Huitron Dealership,1234 St ave,222-777-8888")) {
                        break;
                    }
                }
            }
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
                    vehicleList.add(newVehicle);
                    dealership.addVehicle(newVehicle);
                } else {
                    System.out.println("Invalid data in the file: " + VEHICLES_FILE_PATH);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + VEHICLES_FILE_PATH);
        } catch (IOException ex) {
            System.out.println("Error reading file: " + VEHICLES_FILE_PATH);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid data format in the file: " + VEHICLES_FILE_PATH);
        }

        return dealership;
    }
    static void saveVehicleToInventory(Vehicle newVehicle) {
        try {
            List<String> lines = Files.readAllLines(VEHICLES_FILE_PATH);

            boolean fileExists = !lines.isEmpty();

            try (FileWriter newVehicleWriter = new FileWriter(VEHICLES_FILE_PATH.toFile(), true)) {
                if (!fileExists || isFileEmpty()) {
                    newVehicleWriter.write("Huitron Dealership,1234 St ave,222-777-8888\n");
                }

                if (!vinAlreadyExists(lines, newVehicle.getVin())) {
                    newVehicleWriter.write('\n');
                    // Write new vehicle data
                    StringBuilder csvLine = new StringBuilder()
                            .append(newVehicle.getVin()).append(',')
                            .append(newVehicle.getYear()).append(',')
                            .append(newVehicle.getMake()).append(',')
                            .append(newVehicle.getModel()).append(',')
                            .append(newVehicle.getVehicleType()).append(',')
                            .append(newVehicle.getColor()).append(',')
                            .append(newVehicle.getOdometer()).append(',')
                            .append(newVehicle.getPrice());
                    newVehicleWriter.write(csvLine.toString());
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    private static boolean vinAlreadyExists(List<String> lines, int vin) {
        for (String line : lines) {
            String[] vehicle = line.split(",");
            if (vehicle.length > 0) {
                try {
                    int existingVin = Integer.parseInt(vehicle[0]);
                    if (existingVin == vin) {
                        return true;
                    }
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return false;
    }
    static boolean isFileEmpty() throws IOException {
        return Files.size(DealershipFileManager.VEHICLES_FILE_PATH) == 0;
    }
}