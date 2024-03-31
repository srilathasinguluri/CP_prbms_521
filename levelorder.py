from collections import deque

# Node class representing each node in the binary tree
class Node:
    def __init__(self, key):
        self.data = key
        self.left = None
        self.right = None

# BinaryTree class representing the binary tree and its traversal methods
class BinaryTree:
    def __init__(self):
        self.root = None

    # Method to perform level order traversal
    def levelOrderTraversal(self, root):
        if root is None:
            return

        queue = deque()
        queue.append(root)

        while queue:
            temp_node = queue.popleft()
            print(temp_node.data, end=" ")

            if temp_node.left:
                queue.append(temp_node.left)
            if temp_node.right:
                queue.append(temp_node.right)

# Creating a binary tree
tree = BinaryTree()
tree.root = Node(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

# Performing level order traversal
print("Level Order Traversal:")
tree.levelOrderTraversal(tree.root)
