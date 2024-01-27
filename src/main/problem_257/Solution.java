package main.problem_257;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if (isNull(root.left) && isNull(root.right)) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        if (nonNull(root.left)) {
            search(paths, String.valueOf(root.val), root.left);
        }

        if (nonNull(root.right)) {
            search(paths, String.valueOf(root.val), root.right);
        }

        return paths;
    }

    public void search(List<String> res, String currentPath, TreeNode node) {
        currentPath += "->" + node.val;

        if (isNull(node.left) && isNull(node.right)) {
            res.add(currentPath);
        }

        if (nonNull(node.left)) {
            search(res, currentPath, node.left);
        }

        if (nonNull(node.right)) {
            search(res, currentPath, node.right);
        }
    }
}
