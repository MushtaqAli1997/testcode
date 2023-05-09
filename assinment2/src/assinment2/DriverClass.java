package assinment2;

import assinment2.SkewedBST.Node;

public class DriverClass {

    public static void main(String[] args) {
        SkewedBST bst = new SkewedBST();
        Node root = null;

        // Input the node values
        int[] values = {50, 30, 60, 10, 55};
        for (int value : values) {
            root = bst.insertNode(root, value);
        }

        // Convert to a skewed tree
        Node skewedRoot = SkewedBST.convertToSkewedTree(root);

        // Output the node values in ascending order
        System.out.println("Node values in ascending order:");
        SkewedBST.inorderTraversal(skewedRoot);
    }
}