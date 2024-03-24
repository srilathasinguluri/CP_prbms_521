package dsa;

import java.util.HashSet;
import java.util.Scanner;

public class removedupll {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    // Method to insert a node at the end of the linked list
    static void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to display the linked list
    static void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete duplicates from the linked list
    static void deleteDuplicates() {
        if (head == null || head.next == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (set.contains(current.data)) {
                previous.next = current.next; // Skip the duplicate node
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the elements of the linked list
        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            insert(data);
        }

        // Display the original linked list
        System.out.println("Original linked list:");
        display();

        // Delete duplicates from the linked list
        deleteDuplicates();

        // Display the linked list after deleting duplicates
        System.out.println("Linked list after deleting duplicates:");
        display();

        scanner.close();
    }
}
