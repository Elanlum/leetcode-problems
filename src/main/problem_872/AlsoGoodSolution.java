package main.problem_872;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class AlsoGoodSolution {

    private final Queue<Integer> queue = new ArrayDeque<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        fillQueue(root1);

        return checkQueue(root2) && queue.isEmpty();
    }

    private void fillQueue(TreeNode node) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            queue.add(node.val);
        }

        fillQueue(node.left);
        fillQueue(node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private boolean checkQueue(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (isLeaf(node)) {
            return Objects.equals(queue.poll(), node.val);
        }

        return checkQueue(node.left) && checkQueue(node.right);
    }
}
