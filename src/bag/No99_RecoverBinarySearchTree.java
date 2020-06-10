package bag;

/**
 * @author YoSaukit
 * @date 2020/3/1 15:14
 */
public class No99_RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        if (root == null)return;
        recoverTree(root.left);

    }
}
