package main.problem_872;

import java.util.*;

//https://leetcode.com/problems/leaf-similar-trees
public class GoodSolution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        findLeaf(root1, list1);
        findLeaf(root2, list2);

        return list1.equals(list2);
     }

    private void findLeaf(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            list.add(node.val);
        }

        findLeaf(node.left, list);
        findLeaf(node.right, list);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
