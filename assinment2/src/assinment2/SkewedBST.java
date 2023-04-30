package assinment2;

public class SkewedBST {

    // Node class for binary search tree
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Convert a complete binary search tree into a skewed tree
    public static Node convertToSkewedTree(Node root) {
        // Base case
        if (root == null) {
            return null;
        }

        // Recursively convert the left subtree
        Node left = convertToSkewedTree(root.left);

        // Make the root the right child of the left subtree's rightmost node
        if (left != null) {
            Node rightmost = left;
            while (rightmost.right != null) {
                rightmost = rightmost.right;
            }
            rightmost.right = root;
        }

        // Recursively convert the right subtree
        Node right = convertToSkewedTree(root.right);

        // Return the root of the skewed tree
        root.left = null;
        root.right = right;
        return left != null ? left : root;
    }

    // Inorder traversal of the skewed tree
    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Create a complete binary search tree
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.right.left = new Node(55);

        // Convert to a skewed tree and print the node values in ascending order
        Node skewedRoot = convertToSkewedTree(root);
        inorderTraversal(skewedRoot);
    }
}


