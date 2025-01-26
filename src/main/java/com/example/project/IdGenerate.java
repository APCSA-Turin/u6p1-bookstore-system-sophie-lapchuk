package com.example.project;

public class IdGenerate {  
    
    private static String currentId = "99"; //initialize static id to 99

    public IdGenerate() {} //empty constructor for utility class

    //method to return current id
    public static String getCurrentId() { 
        return currentId;
    }

    //method to reset id value back to 99
    public static void reset() { 
        currentId = "99";
    }

    //method to generate a new id (increased by 1)
    public static void generateID() {
        int id = Integer.parseInt(currentId); //change the string to an int that can be manipulated
        id++;
        currentId = "" + id;
    }

// test code
    public static void main(String[] args) {
        IdGenerate.reset();
        IdGenerate.generateID(); //100
        System.out.println("Test 1: (expected 100): " + currentId);
        IdGenerate.generateID(); //101
        System.out.println("Test 1: (expected 101): " + currentId);
        IdGenerate.generateID(); //102
        System.out.println("Test 1: (expected 102): " + currentId);
        IdGenerate.generateID(); //103
        System.out.println("Test 1: (expected 103): " + currentId);
    }
}