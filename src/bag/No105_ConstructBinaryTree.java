package bag;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YoSaukit
 * @date 2020/2/29 20:39
 */
public class No105_ConstructBinaryTree {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        No105_ConstructBinaryTree tree = new No105_ConstructBinaryTree();
        tree.buildTree(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1,inMap);
    }

    TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                       int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {

        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);
        return root;
    }
}

