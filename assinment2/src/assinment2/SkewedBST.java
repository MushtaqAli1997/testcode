package assinment2;

public class SkewedBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node convertToSkewedTree(Node root) {
        if (root == null) {
            return null;
        }

        Node left = convertToSkewedTree(root.left);

        if (left != null) {
            Node rightmost = left;
            while (rightmost.right != null) {
                rightmost = rightmost.right;
            }
            rightmost.right = root;
        }

        Node right = convertToSkewedTree(root.right);

        root.left = null;
        root.right = right;
        return left != null ? left : root;
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else {
            root.right = insertNode(root.right, value);
        }
        return root;
    }
}

