package dsa;

import java.util.Scanner;

public class kqueueusingarray {
    private int[] queues;
    private int[] front;
    private int[] rear;
    private int[] next;
    private int free;
    private int k;
    private int n;

    // Constructor
    public kqueueusingarray(int k, int n) {
        this.k = k;
        this.n = n;
        queues = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = rear[i] = -1;
        }

        // Initialize all spaces as free
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // -1 indicates end of array, i.e., no free space
        free = 0; // Initialize first free index
    }

    // Enqueue operation
    public void enqueue(int queueNumber, int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        int i = free;
        free = next[i]; // Update free to next free index

        if (isEmpty(queueNumber)) {
            front[queueNumber] = rear[queueNumber] = i;
        } else {
            next[rear[queueNumber]] = i;
            rear[queueNumber] = i;
        }
        queues[i] = item;
        next[i] = -1; // -1 indicates end of queue
    }

    // Dequeue operation
    public int dequeue(int queueNumber) {
        if (isEmpty(queueNumber)) {
            System.out.println("Queue " + queueNumber + " is empty. Cannot dequeue.");
            return -1;
        }

        int i = front[queueNumber];
        front[queueNumber] = next[i]; // Update front to next element
        next[i] = free; // Update next to previous free index
        free = i; // Update free to dequeued index
        return queues[i];
    }

    // Peek operation
    public int peek(int queueNumber) {
        if (isEmpty(queueNumber)) {
            System.out.println("Queue " + queueNumber + " is empty. Cannot peek.");
            return -1;
        }
        return queues[front[queueNumber]];
    }

    // Check if queue is empty
    public boolean isEmpty(int queueNumber) {
        return front[queueNumber] == -1;
    }

    // Check if all queues are full
    public boolean isFull() {
        return free == -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queues (K): ");
        int k = scanner.nextInt();
        System.out.print("Enter the size of each queue (N): ");
        int n = scanner.nextInt();

        kqueueusingarray kQueues = new kqueueusingarray(k, n);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter queue number: ");
                    int queueNumber = scanner.nextInt();
                    if (queueNumber < 0 || queueNumber >= k) {
                        System.out.println("Invalid queue number.");
                        break;
                    }
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    kQueues.enqueue(queueNumber, element);
                    break;
                case 2:
                    System.out.print("Enter queue number: ");
                    queueNumber = scanner.nextInt();
                    if (queueNumber < 0 || queueNumber >= k) {
                        System.out.println("Invalid queue number.");
                        break;
                    }
                    int dequeuedItem = kQueues.dequeue(queueNumber);
                    if (dequeuedItem != -1) {
                        System.out.println("Dequeued element: " + dequeuedItem);
                    }
                    break;
                case 3:
                    System.out.print("Enter queue number: ");
                    queueNumber = scanner.nextInt();
                    if (queueNumber < 0 || queueNumber >= k) {
                        System.out.println("Invalid queue number.");
                        break;
                    }
                    int frontItem = kQueues.peek(queueNumber);
                    if (frontItem != -1) {
                        System.out.println("Front element of queue " + queueNumber + ": " + frontItem);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
