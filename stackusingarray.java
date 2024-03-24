import java.util.*;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack.
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push.");
            return;
        }
        stack[++top] = item;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return stack[top--];
    }

    // Method to peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of the stack: ");
        int capacity = scanner.nextInt();

        ArrayStack stack = new ArrayStack(capacity);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
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
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
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
