package bag;

//import com.sun.javafx.image.IntPixelGetter;

/**
 * @author YoSaukit
 * @date 2020/2/29 17:06
 */
public class No124_BinaryTreeMaxPathSum {


    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {
        No124_BinaryTreeMaxPathSum sum = new No124_BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(-10);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rl = new TreeNode(15);
        TreeNode rr = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rl;
        right.right = rr;
        sum.maxPathSum(root);
        System.out.println(ans);
    }
    public int maxPathSum(TreeNode root) {
        return oneSideMax(root);
    }

    public int oneSideMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}