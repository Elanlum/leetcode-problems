package main.problem_257;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

//https://leetcode.com/problems/binary-tree-paths/description/
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if (isNull(root.left) && isNull(root.right)) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        if (nonNull(root.left)) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            search(paths, sb, root.left);
        }

        if (nonNull(root.right)) {
            StringBuilder sb = new StringBuilder();
            sb.append(root.val);
            search(paths, sb, root.right);
        }

        return paths;
    }

    public void search(List<String> res, StringBuilder sb, TreeNode node) {
        sb.append("->");
        sb.append(node.val);

        if (isNull(node.left) && isNull(node.right)) {
            res.add(sb.toString());
        }

        if (nonNull(node.left)) {
            search(res, new StringBuilder(sb), node.left);
        }

        if (nonNull(node.right)) {
            search(res, new StringBuilder(sb), node.right);
        }
    }
}
