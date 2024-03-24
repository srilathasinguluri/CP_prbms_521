package dsa;

public class stackusingarray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public stackusingarray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element.");
            return;
        }
        stackArray[++top] = value;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1;
        }
        return stackArray[top--];
    }

    // Method to peek the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return -1;
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }
    public void printArray() {
        System.out.println("Contents of the stack array:");
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArray[i]);
        }
    }
    public static void main(String[] args) {
        stackusingarray stack = new stackusingarray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        
        stack.printArray();
    }
}
