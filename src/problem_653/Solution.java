package problem_653;

import java.util.HashSet;

public class Solution {

    private final HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        int find = k - root.val;

        if (set.contains(root.val)) {
            return true;
        }

        set.add(find);

        if (findTarget(root.left, k)) {
            return true;
        }

        return findTarget(root.right, k);
    }

}
