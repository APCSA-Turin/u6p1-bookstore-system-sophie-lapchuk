package com.example.project;

public class Book {
    //instance variables
    private String title;
    private String author;
    private int yearPublished;
    private String ibsn;
    private int quantity;

    //constructor for book with all appropriate data
    public Book(String title, String author, int yearPublished, String ibsn, int quantity) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.ibsn = ibsn;
        this.quantity = quantity;
    }
   
    //method to return title
    public String getTitle() {
        return title;
    }

    //method to set a new title
    public void setTitle(String newTitle) {
        title = newTitle;
    }

    //method to get the author
    public String getAuthor() {
        return author;
    }

    //method to set a new author name
    public void setAuthor(String newAuthor) {
        author = newAuthor;
    }

    //method to return the year a book was published
    public int getYearPublished() {
        return yearPublished;
    }

    //method to set the year a book was published
    public void setYearPublished(int newYear) {
        yearPublished = newYear;
    }

    //method to get a book's isbn
    public String getIsbn() {
        return ibsn;
    }

    //method to set a book's isbn
    public void setIsbn(String newIbsn) {
        ibsn = newIbsn;
    }

    //method to get the amount of books
    public int getQuantity() {
        return quantity;
    }

    //method to set a new quantity of books
    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    //method to print all book info in one string
    public String bookInfo() {
        String str = "";
        str += "Title: " + getTitle() + ", ";
        str += "Author: " + getAuthor() + ", ";
        str += "Year: " + getYearPublished() + ", ";
        str += "ISBN: " + getIsbn() + ", ";
        str += "Quantity: " + getQuantity();
        return str;
    }

    //test code(ignore)
    public static void main(String[] args) {
        //testing constructor
        Book b = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        System.out.println(b.bookInfo());
        System.out.println("/////////////////////");
        //testing setters
        b.setTitle("Untitled");
        b.setAuthor("John Doe");
        b.setIsbn("0000");
        b.setQuantity(1);
        b.setYearPublished(1900);
        System.out.println(b.bookInfo());
    }
      
}