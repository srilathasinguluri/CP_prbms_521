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





***************************PYTHON**************************************

    class Stack:
    def __init__(self, size):
        self.size = size
        self.stack = [None] * size
        self.top = -1

    def is_empty(self):
        return self.top == -1

    def is_full(self):
        return self.top == self.size - 1

    def push(self, item):
        if self.is_full():
            print("Stack is full. Cannot push item.")
        else:
            self.top += 1
            self.stack[self.top] = item

    def pop(self):
        if self.is_empty():
            print("Stack is empty. Nothing to pop.")
            return None
        else:
            item = self.stack[self.top]
            self.stack[self.top] = None
            self.top -= 1
            return item

    def peek(self):
        if self.is_empty():
            print("Stack is empty. Nothing to peek.")
            return None
        else:
            return self.stack[self.top]

    def display(self):
        if self.is_empty():
            print("Stack is empty.")
        else:
            print("Stack elements:")
            for i in range(self.top, -1, -1):
                print(self.stack[i])


# Get stack size from user input
stack_size = int(input("Enter the size of the stack: "))
my_stack = Stack(stack_size)
print("\nStack Operations:")
print("1. Push")
print("2. Pop")
print("3. Peek")
print("4. Display")
print("5. Exit")
while True:  
    choice = input("Enter your choice (1-5): ")

    if choice == '1':
        item = int(input("Enter the item to push onto the stack: "))
        my_stack.push(item)
    elif choice == '2':
        popped_item = my_stack.pop()
        if popped_item is not None:
            print("Popped item:", popped_item)
    elif choice == '3':
        peek_item = my_stack.peek()
        if peek_item is not None:
            print("Top element:", peek_item)
    elif choice == '4':
        my_stack.display()
    elif choice == '5':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please enter a valid option (1-5).")
