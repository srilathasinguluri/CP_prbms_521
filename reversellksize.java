package dsa;
import java.util.Scanner;

public class reversellksize {
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

    // Method to reverse a sublist of the linked list with block size K
    static Node reverseKBlock(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse the first K nodes of the linked list
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursive call for the remaining nodes
        if (next != null) {
            head.next = reverseKBlock(next, k);
        }

        return prev; // New head of the reversed sublist
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

        // Input the block size K
        System.out.print("Enter the block size (K): ");
        int k = scanner.nextInt();

        // Display the original linked list
        System.out.println("Original linked list:");
        display();

        // Reverse the linked list in blocks of size K
        head = reverseKBlock(head, k);

        // Display the reversed linked list
        System.out.println("Linked list after reversing in blocks of size " + k + ":");
        display();

        scanner.close();
    }
}
