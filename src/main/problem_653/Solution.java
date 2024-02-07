package main.problem_653;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    private TreeNode globalRoot = null;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (globalRoot == null) {
            globalRoot = root;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            int find = k - node.val;

            TreeNode found = binarySearch(globalRoot, find);

            if (found != null && found != root) {
                return true;
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return false;
    }

    private TreeNode binarySearch(TreeNode node, int find) {
        if (node == null) {
            return null;
        }

        if (find < node.val) {
            return binarySearch(node.left, find);
        }

        if (find > node.val) {
            return binarySearch(node.right, find);
        }

        return node;
    }
}
