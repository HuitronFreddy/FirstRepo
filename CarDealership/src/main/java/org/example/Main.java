package org.example;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.getDealership();
        //What's to prevent me from making my own dealership, not putting any vehicles in it
        //and then passing it to the user interface?
        UserInterface userInterface = new UserInterface(dealership);

        userInterface.display();
    }
}