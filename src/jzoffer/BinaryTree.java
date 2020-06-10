package jzoffer;

import java.util.*;

/**
 * @author YoSaukit
 * @date 2020/5/20 22:57
 */
public class BinaryTree {
    //1. 深度有点遍历：递归或栈实现
    //2. 层序遍历：队列实现

    /**
     * 层序遍历二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(tmp.val);
            if (tmp.left != null) queue.add(tmp.left);
            if (tmp.right != null) queue.add(tmp.right);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            res.add(new ArrayList<>(list));
            list.clear();
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                list.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            if (level % 2 != 0) {
                Collections.reverse(list);
            }
            res.add(new ArrayList<>(list));
            level++;
            list.clear();
        }
        return res;
    }

    /**
     * 二叉树的镜像
     */
    public TreeNode mirrorTree(TreeNode root) {
        return swap(root);
    }

    TreeNode swap(TreeNode root) {
        if (root == null) return root;
        swap(root.left);
        swap(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            depth++;
        }
        return depth;
    }
//    public int maxDepth1(TreeNode root){
//        if (root == null)return 0;
//        return Math.max(maxDepth1(root.left),maxDepth1(root.right))+1;
//    }

    /**
     * ++++++++++++++++二叉树的最近公共祖先+++++++++++++++++++
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)return res;
        dfs(root,sum);
        return res;
    }
    private void dfs(TreeNode node,int target){
        if (node == null)return;
        list.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null){
            res.add(new ArrayList<>(list));
        }
        dfs(node.left,target);
        dfs(node.right,target);
        list.remove(list.size()-1);
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