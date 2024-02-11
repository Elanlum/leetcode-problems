package main.problem_872;

import java.util.*;

public class NotSoGoodSolution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = findLeafs(root1);
        List<Integer> leafs2 = findLeafs(root2);

        return Objects.equals(leafs1, leafs2);

    }

    private List<Integer> findLeafs(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null) {
                list.add(node.val);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
