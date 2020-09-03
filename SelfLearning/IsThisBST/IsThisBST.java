package SelfLearning.IsThisBST;

import java.util.Stack;

public class IsThisBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        return checkBSTRecursive(root, null, null);
        // return checkBSTIterative(root);
    }

    public boolean checkBSTRecursive(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;
        // Check current binary search
        if (lower != null && node.val <= lower)
            return false;
        if (upper != null && node.val >= upper)
            return false;

        // Dive to check children both sides
        if (!checkBSTRecursive(node.right, node.val, upper))
            return false;
        if (!checkBSTRecursive(node.left, lower, node.val))
            return false;

        return true;
    }

    public boolean checkBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            // Move root next until leaf node and push to stack
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // Then we got leaf node => pop to check
            root = stack.pop();
            // If it's lower than current Inorder value
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int data) {
            this.val = data;
        }
    }
}