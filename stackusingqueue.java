package dsa;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stackusingqueue {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;

    // Constructor
    public stackusingqueue() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    // Push operation
    public void push(int item) {
        mainQueue.add(item);
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }
        int poppedItem = mainQueue.remove();
        swapQueues();
        return poppedItem;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        while (mainQueue.size() > 1) {
            tempQueue.add(mainQueue.remove());
        }
        int topItem = mainQueue.peek();
        tempQueue.add(mainQueue.remove());
        swapQueues();
        return topItem;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return mainQueue.isEmpty() && tempQueue.isEmpty();
    }

    // Swap mainQueue and tempQueue references
    private void swapQueues() {
        Queue<Integer> temp = mainQueue;
        mainQueue = tempQueue;
        tempQueue = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stackusingqueue stack = new stackusingqueue();

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

***************************PYTHON*****************************************

class StackUsingQueue:
    def __init__(self):
        self.queue = []

    def is_empty(self):
        return len(self.queue) == 0

    def push(self, item):
        # Get the current size of the queue
        n = len(self.queue)
        # Add the new item to the end of the queue
        self.queue.append(item)
        # Rotate the queue to bring the new item to the front
        for _ in range(n):
            self.queue.append(self.queue.pop(0))

    def pop(self):
        if self.is_empty():
            print("Stack is empty. Cannot pop.")
            return None
        return self.queue.pop(0)

    def peek(self):
        if self.is_empty():
            print("Stack is empty. Nothing to peek.")
            return None
        return self.queue[0]

    def display(self):
        if self.is_empty():
            print("Stack is empty.")
        else:
            print("Stack elements:")
            for item in self.queue:
                print(item)


# Create a stack object
stack = StackUsingQueue()
print("stack implementation using queue")
while True:
    print("\nStack Operations:")
    print("1. Push")
    print("2. Pop")
    print("3. Peek")
    print("4. Display")
    print("5. Exit")

    choice = input("Enter your choice (1-5): ")

    if choice == '1':
        item = input("Enter the item to push onto the stack: ")
        stack.push(item)
    elif choice == '2':
        popped_item = stack.pop()
        if popped_item is not None:
            print("Popped item:", popped_item)
    elif choice == '3':
        peek_item = stack.peek()
        if peek_item is not None:
            print("Top element:", peek_item)
    elif choice == '4':
        stack.display()
    elif choice == '5':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please enter a valid option (1-5).")
