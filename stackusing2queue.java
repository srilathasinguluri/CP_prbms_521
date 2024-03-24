package dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stackusing2queue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor
    public stackusing2queue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation
    public void push(int item) {
        queue1.add(item);
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int poppedItem = queue1.remove();
        swapQueues();
        return poppedItem;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        int topItem = queue1.peek();
        queue2.add(queue1.remove());
        swapQueues();
        return topItem;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    // Swap queue1 and queue2 references
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stackusing2queue stack = new stackusing2queue();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    int poppedItem = stack.pop();
                    if (poppedItem != -1) {
                        System.out.println("Popped element: " + poppedItem);
                    }
                    break;
                case 3:
                    int topItem = stack.peek();
                    if (topItem != -1) {
                        System.out.println("Top element: " + topItem);
                    }
                    break;
                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
