package dsa;
import java.util.Scanner;

public class linkedlistopr {
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

    // Method to print the linked list
    static void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to reverse the linked list
    static void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Method to sort the linked list (using bubble sort)
    static void sort() {
        if (head == null) {
            return;
        }
        Node current, index;
        int temp;
        for (current = head; current != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }

    // Method to update a node at a given position with new data
    static void update(int position, int newData) {
        if (head == null) {
            System.out.println("List is empty. Cannot update.");
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == position) {
                current.data = newData;
                return;
            }
            current = current.next;
            count++;
        }
        System.out.println("Position out of range. Cannot update.");
    }

    // Method to split the linked list into two halves
    static void split() {
        if (head == null || head.next == null) {
            System.out.println("Cannot split. List has less than two elements.");
            return;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        Node secondHalf = slowPointer.next;
        slowPointer.next = null;
        System.out.println("First half:");
        display(head);
        System.out.println("Second half:");
        display(secondHalf);
    }

    // Method to merge two sorted linked lists
    static Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data < list2.data) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    // Method to link two single linked lists
    static void link(Node list1, Node list2) {
        if (list1 == null) {
            head = list2;
            return;
        }
        Node current = list1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = list2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Reverse");
            System.out.println("4. Sort");
            System.out.println("5. Update");
            System.out.println("6. Split");
            System.out.println("7. Merge");
            System.out.println("8. Link");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    int data = scanner.nextInt();
                    insert(data);
                    break;
                case 2:
                    //System.out

                    System.out.println("Linked List:");
                    display();
                    break;
                case 3:
                    reverse();
                    System.out.println("Linked List after reversing:");
                    display();
                    break;
                case 4:
                    sort();
                    System.out.println("Linked List after sorting:");
                    display();
                    break;
                case 5:
                    System.out.print("Enter position to update: ");
                    int position = scanner.nextInt();
                    System.out.print("Enter new data: ");
                    int newData = scanner.nextInt();
                    update(position, newData);
                    System.out.println("Linked List after updating:");
                    display();
                    break;
                case 6:
                    split();
                    break;
                case 7:
                    Node list1 = head;
                    Node list2 = head.next;
                    sort();
                    System.out.println("First linked list:");
                    display(list1);
                    System.out.println("Second linked list:");
                    display(list2);
                    System.out.println("Merged linked list:");
                    Node mergedList = merge(list1, list2);
                    display(mergedList);
                    break;
                case 8:
                    System.out.println("Create another linked list to link with the current one.");
                    Node list2Head = null;
                    System.out.print("Enter the number of elements in the second linked list: ");
                    int numElements = scanner.nextInt();
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < numElements; i++) {
                        int element = scanner.nextInt();
                        insert(element, list2Head);
                    }
                    System.out.println("Linked list before linking:");
                    display();
                    System.out.println("Linked list to be linked:");
                    display(list2Head);
                    link(head, list2Head);
                    System.out.println("Linked list after linking:");
                    display();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // Method to insert a node at the end of the linked list
    static void insert(int data, Node head) {
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
    static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}


