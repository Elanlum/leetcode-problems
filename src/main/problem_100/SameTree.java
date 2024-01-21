package main.problem_100;

//https://leetcode.com/problems/same-tree/
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode leftp = new TreeNode(2);
        TreeNode rightp = new TreeNode(3);
        TreeNode p = new TreeNode(1, leftp, rightp);

        TreeNode leftq = new TreeNode(2);
        TreeNode rightq = new TreeNode(3);
        TreeNode q = new TreeNode(1, leftq, rightq);
        System.out.println(isSameTree(p, q));
    }
}
