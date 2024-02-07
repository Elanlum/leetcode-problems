package problem_653;

public class RecursiveSolution {

    private TreeNode globalRoot = null;

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (globalRoot == null) {
            globalRoot = root;
        }

        TreeNode node = binarySearch(globalRoot, k - root.val);

        if (node != null && node != root) {
            return true;
        }

        return findTarget(root.left, k) || findTarget(root.right, k);
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
