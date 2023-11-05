package org.example;

import java.util.Scanner;

import static org.example.Book.showAvailableBooks;
import static org.example.Book.showCheckedOutBooks;

/*
Really good job. It works well. Checking out and checking in is all functional.
You broke things down into methods to make it easier to read and re-usable.
It might be nice to allow the user to check out the book in the first menu rather
than making them jump through an extra hoop. My only real advice is using a constructor for less typing
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];

        books[0] = new Book(1, "0123", "The Name of the Wind", true, "Chris");
        books[1] = new Book(2, "0124", "Sapiens: A Brief History of Humankind", true, "Adam");
        books[2] = new Book(3, "0125", "The Road to Wigan Pier", true, "Jairo");
        books[3] = new Book(4, "0126", "TThe Silent Patient", true, "Aaryan");
        //This is where the constructor overload comes in handy
        books[4] = new Book(5, "0127", "Dune");
        books[5] = new Book(6, "0128", "The Girl with the Dragon Tattoo", false, "");
        books[6] = new Book(7, "0129", "The Goldfinch", false, "");
        books[7] = new Book(8, "0133", "The Testaments", false, "");
        books[8] = new Book(9, "0134", "Educated", false, "");
        books[9] = new Book(10, "0135", "The Night Circus", false, "");
        books[10] = new Book(11, "0136", "The Martian", false, "");
        books[11] = new Book(12, "0137", "Circe", false, "");
        books[12] = new Book(13, "0138", "The Power of Habit", false, "");
        books[13] = new Book(14, "0139", "Where the Crawdads Sing", false, "");
        books[14] = new Book(15, "0143", "The Tattooist of Auschwitz", false, "");
        books[15] = new Book(16, "0144", "Normal People", false, "");
        books[16] = new Book(17, "0145", "The Overstory", false, "");
        books[17] = new Book(18, "0146", "Becoming", false, "");
        books[18] = new Book(19, "0147", "Born a Crime: Stories from a South African Childhood", false, "");
        books[19] = new Book(20, "0148", "The Glass Castle", false, "");


        while (true){
            System.out.println("What do you want to do?");
            System.out.println(" 1 - Show Available Books");
            System.out.println(" 2 - Show Checked Out Books");
            System.out.println(" 3 - Exit - closes out of the application");
            System.out.println("Enter a command number: ");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    showAvailableBooks(books);
                    System.out.println("What do you want to do?");
                    System.out.println(" 1 - Select a book to check out");
                    System.out.println(" 2 - Exit - goes back to home screen");
                    System.out.println("Enter a command number: ");

                    int availableBooksOptions = scanner.nextInt();
                    scanner.nextLine();

                    switch (availableBooksOptions) {
                        case 1:
                            showAvailableBooks(books);
                            System.out.println("Enter the book number to check out: ");
                            int bookNumber = scanner.nextInt();
                            scanner.nextLine();
                            //if statement checks if bookNumber >= 1, bookNumber is the book the user wants to check out
                            //also checks if user input is within the range of the array
                            if (bookNumber >= 1 && bookNumber <= books.length) {
                                //if condition is met execute code below
                                //-1 index due to java being zero based to ensure correct book is pulled from array
                                Book selectedBook = books[bookNumber - 1];
                                //calling checkOut method
                                selectedBook.checkOut();
                            } else {
                                System.out.println("Invalid book number.");
                            }
                            break;

                        case 2:
                        default:
                            System.out.println("Returning to home screen.");
                            break;
                    }
                    break;

                case 2:
                    showCheckedOutBooks(books);
                    System.out.println("Would you like to: ");
                    System.out.println(" C - Check in a book");
                    System.out.println(" X - Exit - goes back to home screen");
                    System.out.println("Enter a command letter: ");

                    String checkedOutBooksOptions = scanner.nextLine();

                    if (checkedOutBooksOptions.equalsIgnoreCase("c")) {
                        System.out.println("Enter the book number to check in: ");
                        int bookNumber = scanner.nextInt();
                        scanner.nextLine();

                        if (bookNumber >= 1 && bookNumber <= books.length) {
                            Book selectedBook = books[bookNumber - 1];
                            selectedBook.checkIn();
                        } else {
                            System.out.println("Invalid book number.");
                        }
                    }
                    else if (checkedOutBooksOptions.equalsIgnoreCase("x")) {
                    }
                    else {
                        System.out.println("Invalid command. Returning to the home screen.");
                    }
                    break;

                case 3:
                    System.exit(0);
            }

        }

    }

}