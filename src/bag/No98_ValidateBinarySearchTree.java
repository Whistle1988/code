package bag;

/**
 * @author YoSaukit
 * @date 2019/9/26 16:01
 */
public class No98_ValidateBinarySearchTree {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long minVal,long maxVal){
        if (root == null)return true;
        if (root.val>=maxVal||root.val<=minVal) return false;
        return isValidBST(root.left,minVal,root.val)&&isValidBST(root.right,root.val,maxVal);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



