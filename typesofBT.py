class Node:
    def __init__(self, key):
        self.data = key
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    # Method to insert a node into the binary tree
    def insert(self, data):
        if self.root is None:
            self.root = Node(data)
        else:
            self._insert_recursive(self.root, data)

    def _insert_recursive(self, node, data):
        if data < node.data:
            if node.left is None:
                node.left = Node(data)
            else:
                self._insert_recursive(node.left, data)
        elif data > node.data:
            if node.right is None:
                node.right = Node(data)
            else:
                self._insert_recursive(node.right, data)

    # Method to check if the binary tree is full
    def is_full(self, node):
        if node is None:
            return True
        if node.left is None and node.right is None:
            return True
        if node.left is not None and node.right is not None:
            return (self.is_full(node.left) and self.is_full(node.right))
        return False

    # Method to check if the binary tree is complete
    def is_complete(self, root):
        if root is None:
            return True
        queue = []
        queue.append(root)
        flag = False
        while queue:
            temp_node = queue.pop(0)
            if temp_node.left:
                if flag:
                    return False
                queue.append(temp_node.left)
            else:
                flag = True
            if temp_node.right:
                if flag:
                    return False
                queue.append(temp_node.right)
            else:
                flag = True
        return True

    # Method to check if the binary tree is perfect
    def is_perfect(self, node, depth, level=0):
        if node is None:
            return True
        if node.left is None and node.right is None:
            return depth == level + 1
        if node.left is None or node.right is None:
            return False
        return (self.is_perfect(node.left, depth, level + 1) and
                self.is_perfect(node.right, depth, level + 1))

    # Method to calculate the height of the binary tree
    def height(self, node):
        if node is None:
            return 0
        else:
            left_height = self.height(node.left)
            right_height = self.height(node.right)
            return max(left_height, right_height) + 1

# Function to create a sample binary tree
def create_sample_tree():
    tree = BinaryTree()
    elements = [1, 2, 3, 4, 5, 6, 7]
    for element in elements:
        tree.insert(element)
    return tree

# Main function to demonstrate binary tree types
def main():
    # Creating a sample binary tree
    tree = create_sample_tree()

    # Checking if the binary tree is full
    print("Is the binary tree full?", tree.is_full(tree.root))

    # Checking if the binary tree is complete
    print("Is the binary tree complete?", tree.is_complete(tree.root))

    # Checking if the binary tree is perfect
    depth = tree.height(tree.root)
    print("Is the binary tree perfect?", tree.is_perfect(tree.root, depth))

    # Calculating the height of the binary tree
    print("Height of the binary tree:", tree.height(tree.root))

if __name__ == "__main__":
    main()
