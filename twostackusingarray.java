package dsa;
public class twostackusingarray {
    private int maxSize;
    private int[] stackArray;
    private int top1, top2;

    // Constructor to initialize the two stacks
    public twostackusingarray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top1 = -1;
        top2 = maxSize;
    }

    // Method to push an element onto the first stack
    public void push1(int value) {
        if (top1 < top2 - 1) {
            stackArray[++top1] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Method to push an element onto the second stack
    public void push2(int value) {
        if (top1 < top2 - 1) {
            stackArray[--top2] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    // Method to pop an element from the first stack
    public int pop1() {
        if (top1 >= 0) {
            return stackArray[top1--];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    // Method to pop an element from the second stack
    public int pop2() {
        if (top2 < maxSize) {
            return stackArray[top2++];
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    public static void main(String[] args) {
        twostackusingarray twoStacks = new twostackusingarray(5);

        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push2(3);
        twoStacks.push2(4);

        System.out.println("Popped element from stack 1: " + twoStacks.pop1());
        System.out.println("Popped element from stack 2: " + twoStacks.pop2());
    }
}
