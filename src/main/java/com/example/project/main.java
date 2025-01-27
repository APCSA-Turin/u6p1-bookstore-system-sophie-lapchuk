package com.example.project;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookStore bookstore = new BookStore(); //new bookstore
        IdGenerate.reset(); //reset static variable
        int input = 1; //set input to 1 in order for loop to run

        while (input != 8) {
            //intro code
            System.out.println();
            System.out.println("********** Barnes and Noble Management **********");
            System.out.println("**************************************************");
            System.out.println("1. Add a Book");
            System.out.println("2. Update Book Quantity");
            System.out.println("3. View all Books");
            System.out.println("4. Search a Book");
            System.out.println("5. Add a Employee");
            System.out.println("6. Remove an Employee");
            System.out.println("7. View all Employees");
            System.out.println("8. Exit Menu");
            System.out.print("Select one: ");
            input = scan.nextInt();
            scan.nextLine();
            System.out.println();

            //add book
            if (input == 1) {
                System.out.print("Enter book title: ");
                String title = scan.nextLine();
                System.out.print("Enter author: ");
                String author = scan.nextLine();
                System.out.print("Enter year published: ");
                int yearPublished = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter ISBN: ");
                String isbn = scan.nextLine();
                System.out.print("Enter quantity: ");
                int quantity = scan.nextInt();
                scan.nextLine();

                Book book = new Book(title, author, yearPublished, isbn, quantity); //new object with all user entered data
                bookstore.addBook(book);
                System.out.println();
                System.out.println("✅ Book was added!");
            }
            
            //remove a book
            else if (input == 2) {
                //get update and book data 
                System.out.print("Enter the ISBN of the book you would to update: ");
                String isbn = scan.nextLine();
                System.out.print("Enter the NEW quantity of this book: ");
                int quantity = scan.nextInt();
                scan.nextLine(); 

                Book book = new Book(null, null, 0, null, 0); //empty book object
                boolean found = false;
                for (Book books : bookstore.getBooks()) {
                    if (books.getIsbn().equals(isbn)) {
                        book = books; //once book is found, update book
                        found = true;
                    }
                }

                System.out.println();
                if (found == false) {
                    System.out.println("❌ Book does not exist."); //if book is not found, does not exist
                } 
                else {
                    book.setQuantity(quantity); //update found book with quantity
                    System.out.println("✅ Book was updated!");
                }
            }

            //view all books
            else if (input == 3) {
                System.out.println();
                System.out.println(bookstore.bookStoreBookInfo());
            }

            //search for a book and display its info
            else if (input == 4) {
                //get data
                System.out.print("Enter the ISBN of the book you would to find: ");
                String isbn = scan.nextLine();

                //new null book
                Book book = new Book(null, null, 0, null, 0); //empty book object
                boolean found = false;

                //search for book and update if found
                for (Book books : bookstore.getBooks()) {
                    if (books.getIsbn().equals(isbn)) {
                        book = books; //once book is found, update book
                        found = true;
                    }
                }
                System.out.println();
                if (found == false) { //if does not exist, will end 
                    System.out.println("❌ Book does not exist.");
                } 
                else { //if exists, prints data
                    System.out.println(book.bookInfo());
                }
            }

            //add an employee
            else if (input == 5) {
                System.out.print("Enter employee name: ");
                String name = scan.nextLine();
                IdGenerate.generateID(); //make new id
                String id = IdGenerate.getCurrentId(); //set the current id to id variable

                User employee = new User(name, id); //make a new employee with the data
                bookstore.addUser(employee);
                bookstore.consolidateUsers();
                bookstore.makeNullUserEmpty();
                System.out.println();
                System.out.println("✅ Employee was added!");
            }

            //remove an employee
            else if (input == 6) {
                bookstore.makeNullUserEmpty();
                boolean found = false;
                System.out.print("Enter the ID of the employee you'd like to remove: ");
                String id = scan.nextLine();

                User employee = new User(null, null); //empty user object

                for (User user : bookstore.getUsers()) { //search users to see if provided user exists
                    if (user.getId().equals(id)) {
                        employee = user;
                        found = true;
                    }
                }

                if (found == false) {
                    System.out.println();
                    System.out.println("❌ Employee does not exist.");
                } 
                else {
                    bookstore.removeUser(employee);
                    System.out.println();
                    System.out.println("✅ Employee was removed!");
                }
            }

            //display all employees
            else if (input == 7) {
                System.out.println(bookstore.bookStoreUserInfo());
            }

            //exit out
            else if (input == 8) {
                break;
            }

            else { //if user does not input proper selection
                System.out.println("❌ Please enter a valid selection!");
            }
        }
        scan.close();
    }
}