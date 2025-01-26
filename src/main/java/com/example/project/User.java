package com.example.project;

public class User{
    //instance variables
    private String name;
    private String id;
    private Book[] books = new Book[5]; //book take out limited to 5

    //constructor for user with name and their id
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }

    //method to return user name
    public String getName() {
        return name;
    }

    //method to set new user name
    public void setName(String newName) {
        name = newName;
    }

    //method to get user id
    public String getId() {
        return id;
    }

    //method to set new user id
    public void setId(String newID) {
        id = newID;
    }

    //method to return books list
    public Book[] getBooks() {
        return books;
    }

    //method to set book list
    public void setBooks(Book[] book) {
        books = book;
    }

    //method to print out all books and their info in a string
    public String bookListInfo() {
        String booklist = "";
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                booklist += "empty\n"; //if book name null, print empty
            }
            else {
                booklist += books[i].bookInfo() + "\n";
            }
        }
        return booklist;
    }

    //method to print user info in one string
    public String userInfo() {
        String str = "";
        str += "Name: " + getName();
        str += "\nId: " + getId();
        str += "\nBooks: ";
        str+= "\n" + bookListInfo();
        return str;
    }
    
    //test code (ignore)
    public static void main(String[] args) {
        IdGenerate.reset(); //reset for test
        IdGenerate.generateID();
        User u1 = new User("John",IdGenerate.getCurrentId());
        String expected1 = "Name: John\nId: 100\nBooks: \nempty\nempty\nempty\nempty\nempty\n";
        System.out.println("TEST 1: " + u1.userInfo());
        System.out.println("TEST 1 EXPECTED: " + expected1);

        System.out.println("///////////////////////");
        IdGenerate.reset(); //reset for test
        IdGenerate.generateID();
        User u2 = new User("John",IdGenerate.getCurrentId());
        String expected2 = "Name: John\nId: 100\nBooks: \nempty\nempty\nempty\nempty\nempty\n";    
        System.out.println("TEST 2: " + u2.userInfo());
        System.out.println("TEST 2 EXPECTED: " + expected2);

        System.out.println("///////////////////////");
        IdGenerate.generateID();
        Book b1 = new Book("The Great Gatsby","Scott Fitzgerald", 1925, "979-8351145013",3);
        User u3 = new User("Jane",IdGenerate.getCurrentId());
        Book[] books = new Book[5];
        books[0] = b1;
        u3.setBooks(books);
        String expected3 = "Name: Jane\nId: 101\nBooks: \nTitle: The Great Gatsby, Author: Scott Fitzgerald, Year: 1925, ISBN: 979-8351145013, Quantity: 3\nempty\nempty\nempty\nempty\n";
        System.out.println("TEST 3: " + u3.userInfo());
        System.out.println("TEST 3 EXPECTED: " + expected3);
    }
       
}