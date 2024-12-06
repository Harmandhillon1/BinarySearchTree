//Harman Dhillon
//Lab 6 BST CS145
//11-26-24
//This program uses a Binary Search Tree that stores and manages employee records.
//Each employee is assigned a id or primary key in which is stored their name, address, 
//email and number. Using that key they are able to edit or delete the employee. 
//This program also allows the user to Traverse the tree allowing you to view it in pre, in or post order.

import java.util.Scanner;

public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    // Add a new employee/node to the BST
    public void addNode(String primaryKey, String firstName, String lastName, String streetAddress, 
                        String city, String state, String zip, String email, String phoneNumber) {
        root = addNodeRec(root, primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
    }

    private Node addNodeRec(Node root, String primaryKey, String firstName, String lastName, 
                            String streetAddress, String city, String state, String zip, 
                            String email, String phoneNumber) {
        if (root == null) {
            return new Node(primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        }
        if (primaryKey.compareTo(root.primaryKey) < 0) {
            root.left = addNodeRec(root.left, primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        } else if (primaryKey.compareTo(root.primaryKey) > 0) {
            root.right = addNodeRec(root.right, primaryKey, firstName, lastName, streetAddress, city, state, zip, email, phoneNumber);
        }
        return root;
    }

    // Delete a node from the BST
    public void deleteNode(String primaryKey) {
        root = deleteNodeRec(root, primaryKey);
    }

    private Node deleteNodeRec(Node root, String primaryKey) {
        if (root == null) {
            return root;
        }
        if (primaryKey.compareTo(root.primaryKey) < 0) {
            root.left = deleteNodeRec(root.left, primaryKey);
        } else if (primaryKey.compareTo(root.primaryKey) > 0) {
            root.right = deleteNodeRec(root.right, primaryKey);
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.primaryKey = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNodeRec(root.right, root.primaryKey);
        }
        return root;
    }

    private String minValue(Node root) {
        String minValue = root.primaryKey;
        while (root.left != null) {
            minValue = root.left.primaryKey;
            root = root.left;
        }
        return minValue;
    }

    // Modify an existing node
    public void modifyNode(String primaryKey, String fieldToModify, String newValue) {
        modifyNodeRec(root, primaryKey, fieldToModify, newValue);
    }

    private void modifyNodeRec(Node root, String primaryKey, String fieldToModify, String newValue) {
        if (root == null) {
            return;
        }
        if (primaryKey.compareTo(root.primaryKey) < 0) {
            modifyNodeRec(root.left, primaryKey, fieldToModify, newValue);
        } else if (primaryKey.compareTo(root.primaryKey) > 0) {
            modifyNodeRec(root.right, primaryKey, fieldToModify, newValue);
        } else {
            // Node with the matching primaryKey found
            switch (fieldToModify) {
                case "firstName":
                    root.firstName = newValue;
                    break;
                case "lastName":
                    root.lastName = newValue;
                    break;
                case "streetAddress":
                    root.streetAddress = newValue;
                    break;
                case "city":
                    root.city = newValue;
                    break;
                case "state":
                    root.state = newValue;
                    break;
                case "zip":
                    root.zip = newValue;
                    break;
                case "email":
                    root.email = newValue;
                    break;
                case "phoneNumber":
                    root.phoneNumber = newValue;
                    break;
                default:
                    System.out.println("Invalid field");
            }
        }
    }

    // Lookup a node by primary key
    public Node lookupNode(String primaryKey) {
        return lookupNodeRec(root, primaryKey);
    }

    private Node lookupNodeRec(Node root, String primaryKey) {
        if (root == null || root.primaryKey.equals(primaryKey)) {
            return root;
        }
        if (primaryKey.compareTo(root.primaryKey) < 0) {
            return lookupNodeRec(root.left, primaryKey);
        }
        return lookupNodeRec(root.right, primaryKey);
    }

    // Pre-order traversal
    public void preOrderTraversal() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName);
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // In-order traversal
    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName);
            inOrderRec(root.right);
        }
    }

    // Post-order traversal
    public void postOrderTraversal() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName);
        }
    }

    // List number of records
    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }
}
