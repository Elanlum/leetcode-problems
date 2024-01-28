package main.problem_257;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/description/
public class SolutionRecursive {

    private final List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, new StringBuilder());
        return result;
    }

    private void binaryTreePaths(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (!sb.isEmpty()) {
            sb.append("->");
        }

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            result.add(sb.toString());
        } else {
            binaryTreePaths(root.left, new StringBuilder(sb));
            binaryTreePaths(root.right, new StringBuilder(sb));
        }
    }
}
