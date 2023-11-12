package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ContractDataManager {

    private static final Path CONTRACTS_FILE_PATH = Paths.get("src", "main", "resources", "Contract.csv");

    public static void saveContract(Contract contract) {
        try {
            List<String> lines = Files.readAllLines(CONTRACTS_FILE_PATH);

            boolean fileExists = !lines.isEmpty();

            try (FileWriter newContractWriter = new FileWriter(CONTRACTS_FILE_PATH.toFile(), true)) {
                if (!fileExists || isFileEmpty()) {
                    newContractWriter.write("Huitron Contracts\n");
                }

                if (contract instanceof SalesContract) {
                    saveSalesContract((SalesContract) contract, newContractWriter);
                } else if (contract instanceof LeaseContract) {
                    saveLeaseContract((LeaseContract) contract, newContractWriter);
                }

                newContractWriter.write('\n');
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    private static void saveSalesContract(SalesContract contract, FileWriter writer) throws IOException {
        writer.write("Sales Contract\n");
        writer.write("Date: " + contract.getDate() + '\n');
        writer.write("Customer Name: " + contract.getCustomerName() + '\n');
        writer.write("Customer Email: " + contract.getCustomerEmail() + '\n');
        writer.write("Vehicle: " + contract.getVehicleSold().getVin() + '\n'); 
        writer.write("Total Price: " + contract.getTotalPrice() + '\n');
        writer.write("Monthly Payment: " + contract.getMonthlyPayment() + '\n');
        writer.write("Sales Tax Amount: " + contract.getSalesTaxAmount() + '\n');
        writer.write("Recording Fee: " + contract.getRecordingFee() + '\n');
        writer.write("Processing Fee: " + contract.getProcessingFee() + '\n');
        writer.write("Finance Option: " + contract.isFinanceOption() + '\n');
    }
    private static void saveLeaseContract(LeaseContract contract, FileWriter writer) throws IOException {
        writer.write("Lease Contract\n");
        writer.write("Date: " + contract.getDate() + '\n');
        writer.write("Customer Name: " + contract.getCustomerName() + '\n');
        writer.write("Customer Email: " + contract.getCustomerEmail() + '\n');
        writer.write("Vehicle: " + contract.getVehicleSold().getVin() + '\n'); 
        writer.write("Total Price: " + contract.getTotalPrice() + '\n');
        writer.write("Monthly Payment: " + contract.getMonthlyPayment() + '\n');
        writer.write("Expected Ending Value: " + contract.getExpectedEndingValue() + '\n');
        writer.write("Lease Fee: " + contract.getLeaseFee() + '\n');
    }
    private static boolean isFileEmpty() throws IOException {
        return Files.size(CONTRACTS_FILE_PATH) == 0;
    }
}
