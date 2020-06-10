package targetOffer;

/**
 * 中序遍历二叉查找树找到第K大的数
 * @author YoSaukit
 * @date 2020/4/12 10:54
 */
public class KthSmallest {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){ val = x; }
    }
    int num = 0;
    int res;
    public int kthSmallest(TreeNode root,int k){
        inorderTraversal(root,k);
        return res;
    }
    private void inorderTraversal(TreeNode node,int k){
        if (node == null)return;
        inorderTraversal(node.left,k);
        num++;
        if (num == k){
            res = node.val;
            return;
        }
        inorderTraversal(node.right,k);
    }
}
