//Harman Dhillon
//Lab 6 BST CS145
//11-26-24
//This program uses a Binary Search Tree that stores and manages employee records.
//Each employee is assigned a id or primary key in which is stored their name, address, 
//email and number. Using that key they are able to edit or delete the employee. 
//This program also allows the user to Traverse the tree allowing you to view it in pre, in or post order.

public class Node {
    // Employee data fields
    String primaryKey;  // A unique identifier for lookup (e.g., employee ID)
    String firstName;
    String lastName;
    String streetAddress;
    String city;
    String state;
    String zip;
    String email;
    String phoneNumber;

    Node left, right;

    // Constructor
    public Node(String primaryKey, String firstName, String lastName, String streetAddress, 
                String city, String state, String zip, String email, String phoneNumber) {
        this.primaryKey = primaryKey;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.left = null;
        this.right = null;
    }
}
