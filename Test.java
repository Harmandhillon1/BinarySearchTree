//Harman Dhillon
//Lab 6 BST CS145
//11-26-24
//This program uses a Binary Search Tree that stores and manages employee records.
//Each employee is assigned a id or primary key in which is stored their name, address, 
//email and number. Using that key they are able to edit or delete the employee. 
//This program also allows the user to Traverse the tree allowing you to view it in pre, in or post order.

import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static BST bst = new BST();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            switch (choice) {
                case 1: // Add record
                    addRecord();
                    break;
                case 2: // Delete record
                    deleteRecord();
                    break;
                case 3: // Modify record
                    modifyRecord();
                    break;
                case 4: // Lookup record
                    lookupRecord();
                    break;
                case 5: // List records
                    listRecords();
                    break;
                case 6: // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    //show menu
    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Modify Record");
        System.out.println("4. Lookup Record");
        System.out.println("5. List Number of Records");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }
    // add record
    private static void addRecord() {
        System.out.print("Enter Primary Key (ID): ");
        String primaryKey = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Street Address: ");
        String streetAddress = scanner.nextLine();
        System.out.print("Enter City: ");
        String city = scanner.nextLine();
        System.out.print("Enter State: ");
        String state = scanner.nextLine();
        System.out.print("Enter Zip Code: ");
        String zip = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Add the record to the BST
        bst.addNode(primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        System.out.println("Record added successfully!");
    }
    // delete record
    private static void deleteRecord() {
        System.out.print("Enter Primary Key (ID) to delete: ");
        String primaryKey = scanner.nextLine();
        // Confirm deletion
        System.out.print("Are you sure you want to delete the record with Primary Key " + primaryKey + " (y/n)? ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("y")) {
            bst.deleteNode(primaryKey);
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
    // modify record
    private static void modifyRecord() {
        System.out.print("Enter Primary Key (ID) to modify: ");
        String primaryKey = scanner.nextLine();
        Node node = bst.lookupNode(primaryKey);
        if (node != null) {
            System.out.println("Record found for Primary Key " + primaryKey);
            System.out.print("Which field would you like to modify (firstName, lastName, streetAddress, city, state, zip, email, phoneNumber)? ");
            String fieldToModify = scanner.nextLine();
            System.out.print("Enter the new value: ");
            String newValue = scanner.nextLine();
            bst.modifyNode(primaryKey, fieldToModify, newValue);
            System.out.println("Record modified successfully.");
        } else {
            System.out.println("No record found with Primary Key " + primaryKey);
        }
    }
    // lookup record
    private static void lookupRecord() {
        System.out.print("Enter Primary Key (ID) to lookup: ");
        String primaryKey = scanner.nextLine();
        Node node = bst.lookupNode(primaryKey);
        if (node != null) {
            System.out.println("Record found:");
            System.out.println("Primary Key: " + node.primaryKey);
            System.out.println("First Name: " + node.firstName);
            System.out.println("Last Name: " + node.lastName);
            System.out.println("Street Address: " + node.streetAddress);
            System.out.println("City: " + node.city);
            System.out.println("State: " + node.state);
            System.out.println("Zip Code: " + node.zip);
            System.out.println("Email: " + node.email);
            System.out.println("Phone Number: " + node.phoneNumber);
        } else {
            System.out.println("No record found with Primary Key " + primaryKey);
        }

        // Ask for traversal type (pre-order, in-order, post-order)
        System.out.print("\nDo you want to see the records in a specific order? (pre-order, in-order, post-order, none): ");
        String order = scanner.nextLine().toLowerCase();

        switch (order) {
            case "pre-order":
                bst.preOrderTraversal();
                break;
            case "in-order":
                bst.inOrderTraversal();
                break;
            case "post-order":
                bst.postOrderTraversal();
                break;
            case "none":
                break;
            default:
                System.out.println("Invalid order type, skipping traversal.");
        }
    }

    // List number of records
    private static void listRecords() {
        int recordCount = bst.countNodes();
        System.out.println("Number of records in the database: " + recordCount);
    }
}
