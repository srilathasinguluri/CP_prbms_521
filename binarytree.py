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

    # Method to perform inorder traversal
    def inorderTraversal(self, node):
        if node:
            self.inorderTraversal(node.left)
            print(node.data, end=" ")
            self.inorderTraversal(node.right)

    # Method to perform preorder traversal
    def preorderTraversal(self, node):
        if node:
            print(node.data, end=" ")
            self.preorderTraversal(node.left)
            self.preorderTraversal(node.right)

    # Method to perform postorder traversal
    def postorderTraversal(self, node):
        if node:
            self.postorderTraversal(node.left)
            self.postorderTraversal(node.right)
            print(node.data, end=" ")

# Creating a binary tree
tree = BinaryTree()
tree.root = Node(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

# Performing traversals
print("Inorder Traversal:")
tree.inorderTraversal(tree.root)
print("\nPreorder Traversal:")
tree.preorderTraversal(tree.root)
print("\nPostorder Traversal:")
tree.postorderTraversal(tree.root)
