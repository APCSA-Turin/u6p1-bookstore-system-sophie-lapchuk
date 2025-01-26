package com.example.project;

public class BookStore {
    //instance variables
    private User[] users = new User[10];
    private Book[] books;

    public BookStore() {} //empty constructor

    //method to return users list
    public User[] getUsers() {
        return users;
    }

    //method to set users list
    public void setUsers(User[] users) {
        this.users = users;
    }

    //method to return books list
    public Book[] getBooks() {
        return books;
    }

    //method to add a new user to the user array
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null || users[i].getName().equals("EMPTY_SLOT")) { //adding user at the first null spot
                users[i] = user;
                break;
            }
        }
    }

    //method to remove the user from the user array
    public void removeUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == user) {
                users[i] = null; //where the user is, make it null
            }
        }
        consolidateUsers(); //reorganize the array to avoid null pointer exception
    }

    //method to move all null spots to the end of the list
    public void consolidateUsers() {
        User[] tempUsers = new User[users.length]; //temporary array to store valid users at the front
        int index = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                tempUsers[index++] = users[i]; //if user is not null, add to the array and increase the index
            }
        }
        users = tempUsers; //reference temp array
    }

    //method to add book quantity OR add new book if not already present in the books array
    public void addBook(Book book) {
        if (books == null) { //if list is empty, add a new book
            this.books = new Book[1];
            books[0] = book;
            return; //early return
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && book.getIsbn().equals(books[i].getIsbn()) ) { //if book is in list, add the quantity
            books[i].setQuantity(books[i].getQuantity() + book.getQuantity());
            return;
            }
        }

        Book[] tempBooks = new Book[books.length + 1]; //new book array with one more book
        for (int i = 0; i < books.length; i++) {
            tempBooks[i] = books[i]; //copy the list
        }
        tempBooks[books.length] = book; //add the new book at the index of the new length of the list
        books = tempBooks; //reference the temp list
    }

    //method to insert book at a specific index
    public void insertBook(Book book, int index) {
        Book[] temp = new Book[books.length + 1]; //new temp list to move everything over
        for (int i = 0; i < index; i++) {
            temp[i] = books[i]; //copy over all books UNTIL the index
        }
        temp[index] = book; //add book at index
        for (int i = index + 1; i < temp.length; i++) {
            temp[i] = books[i-1]; //continue copying over the books after the index
        }
        books = temp; //reference the new array 
    }

    //method to remove 1 book quantity from the array
    public void removeBook(Book book) {
        for (int i = 0; i < books.length; i++) {
            if (books != null && book.getIsbn().equals(books[i].getIsbn())) { //if book exists in the list, remove one
            books[i].setQuantity(books[i].getQuantity() - 1);
            break;
            }
        }
        int length = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getQuantity() != 0) {
                length++; //add to the length of a new list if book quantity is not 0 and the book is not null
            }
        }
        Book[] tempBooks = new Book[length]; //new array with length of books
        int index = 0;
        for (int i = 0; i < books.length ; i++) {
            if (books[i]!= null && books[i].getQuantity() > 0) {
                tempBooks[index] = books[i]; //copy over books
                index++;
            }
        }
    books = tempBooks; //reference new array
    }

    //method to print out book in books in one string
    public String bookStoreBookInfo() {
        String str = "";
        for (Book book : books) {
            str += book.bookInfo() + "\n";
        }
    return str;
    }

    //method to print all users in user array in one string
    public String bookStoreUserInfo() {
        String str = "";
        for (User user : users) {
            if (user == null) {
                str += "EMPTY_SLOT\n";
            } else {
            str += "Name: " + user.getName() + "\n";
            str += "ID: " + user.getId() + "\n";
            }
        }
    return str;
    }

    //method for interface to make null users empty to avoid null exception
    public void makeNullUserEmpty() {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = new User("EMPTY_SLOT", "EMPTY_SLOT");
            }
        }
    }
}