package org.example;

import java.util.Scanner;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    //Typically the constructor comes after the properties
    public void checkOut (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        isCheckedOut = true;
        checkedOutTo = userName;

        System.out.println("You have successfully checked out '" + title + "' with your name: " + checkedOutTo);
    }

    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    //You could do the constructor like this for less typing since you know in the beginning it won't be checked out
    //and it's not checked out to anyone
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public static void showAvailableBooks(Book[] books) {
        // lists all books in array
        for (Book book : books) {
            //will only list books if they are not checked out
            if (!book.isCheckedOut) {
                String bookInfo = "ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle();
                System.out.println(bookInfo);
            }
        }
    }
    public static void showCheckedOutBooks(Book[] books){
        for (Book book : books){
            if (book.isCheckedOut){
                String bookInfo = "ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked out by: " + book.getCheckedOutTo();
                System.out.println(bookInfo);
            }
        }
    }
}
