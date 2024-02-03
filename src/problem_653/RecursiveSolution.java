package problem_653;

public class RecursiveSolution {

    private static TreeNode globalRoot = null;

    public static boolean findTarget(TreeNode root, int k) {
        // корень пустой
        if (root == null) {
            return false;
        }

        if (globalRoot == null) {
            globalRoot = root;
        }

        if (binarySearch(globalRoot, k - root.val, root.val)) {
            return true;
        }

        if (findTarget(root.right, k)) {
            return true;
        }

        return findTarget(root.left, k);
    }

    private static boolean binarySearch(TreeNode node, int find, int nonFind) {
        if (node == null) {
            return false;
        }

        if (find == nonFind) {
            return false;
        }

        if (node.val == find) {
            return true;
        }

        // оба листа есть
        if (node.left != null && node.right != null) {
            return binarySearch(node.left, find, nonFind) || binarySearch(node.right, find, nonFind);
        }

        // только левый
        if (node.left != null) {
            return binarySearch(node.left, find, nonFind);
        }

        // только правый
        if (node.right != null) {
            return binarySearch(node.right, find, nonFind);
        }

        return false;
    }

//    public static void main(String[] args) {
//        TreeNode one = new TreeNode(1, null, null);
//        TreeNode minusFour = new TreeNode(-4, null, null);
////        TreeNode seven = new TreeNode(7, null, null);
//        TreeNode zero = new TreeNode(0, minusFour, one);
//        TreeNode three = new TreeNode(3, null, null);
//
//        TreeNode root = new TreeNode(2, zero, three);
//
//        System.out.println(Solution.findTarget(root, -1));
//    }

//    public static void main(String[] args) {
//        TreeNode three = new TreeNode(3, null, null);
//        TreeNode root = new TreeNode(2, null, three);
//
//        System.out.println(Solution.findTarget(root, 6));
//    }

//    public static void main(String[] args) {
//        TreeNode two = new TreeNode(2, null, null);
//        TreeNode root = new TreeNode(1, null, two);
//
//        System.out.println(Solution.findTarget(root, 2));
//    }

//    public static void main(String[] args) {
//        TreeNode two = new TreeNode(2, null, null);
//        TreeNode root = new TreeNode(1, null, two);
//
//        System.out.println(Solution.findTarget(root, 2));
//    }
}
