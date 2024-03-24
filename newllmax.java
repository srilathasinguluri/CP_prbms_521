package dsa;

public class newllmax {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        static Node insert(Node root, int item) {
            Node temp = new Node(item);
            if (root == null) {
                root = temp;
            } else {
                Node ptr = root;
                while (ptr.next != null) {
                    ptr = ptr.next;
                }
                ptr.next = temp;
            }
            return root;
        }

        static Node newlist(Node root1, Node root2) {
            Node ptr1 = root1;
            Node ptr2 = root2;
            Node root = null;
            while (ptr1 != null && ptr2 != null) {
                int maxElement = Math.max(ptr1.data, ptr2.data);
                root = insert(root, maxElement);
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return root;
        }

        static void display(Node root) {
            while (root != null) {
                System.out.print(root.data);
                if (root.next != null) {
                    System.out.print("->");
                }
                root = root.next;
            }
            System.out.println();  // Print newline at the end
        }
    }

    public static void main(String[] args) {
        Node root1 = null;
        Node root2 = null;
        root1 = Node.insert(root1, 4);
        root1 = Node.insert(root1, 5);
        root1 = Node.insert(root1, 2);
        System.out.print("First list: ");
        Node.display(root1);

        root2 = Node.insert(root2, 7);
        root2 = Node.insert(root2, 9);
        root2 = Node.insert(root2, 1);
        System.out.print("Second list: ");
        Node.display(root2);

        Node root3 = Node.newlist(root1, root2);
        System.out.print("Max element at each position merged list: ");
        Node.display(root3);
    }
}
