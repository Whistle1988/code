package jzoffer;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author YoSaukit
 * @date 2020/5/20 22:57
 */
public class BinaryTree {
    //1. 深度遍历：递归或栈实现
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
        if (root == null) return res;
        dfs(root, sum);
        return res;
    }

    private void dfs(TreeNode node, int target) {
        if (node == null) return;
        list.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(list));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        list.remove(list.size() - 1);
    }

    /**
     * 前序+中序 -> 后序
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> prelist = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inlist = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return _buildTree(prelist, inlist);
    }

    private TreeNode _buildTree(List pre, List in) {
        if (pre.size() == 0) return null;
        int val = (int) pre.get(0);
        TreeNode root = new TreeNode(val);
        int index = in.indexOf(root.val);
        root.left = _buildTree(pre.subList(1, 1 + index), in.subList(0, index));
        root.right = _buildTree(pre.subList(1 + index, pre.size()), in.subList(index + 1, in.size()));
        return root;
    }

    /**
     * 二叉搜索树的后序遍历序列
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) return true;
        return _verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean _verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int root = postorder[right];
        int k = left;
        while (k < right && postorder[k] < root) {
            k++;
        }
        for (int i = k; i < right; i++) {
            if (postorder[i] < root) return false;
        }
        if (!_verifyPostorder(postorder, left, k - 1)) return false;
        if (!_verifyPostorder(postorder, k, right - 1)) return false;
        return true;
    }

    /**
     * 对称的二叉树
     *
     * @param root
     * @return
     */
    //想得太复杂了
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null)return true;
//        List<List<Integer>> list = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        int level = 0;
//        q.add(root);
//        List<Integer> tmpList = new ArrayList<>();
//        while(!q.isEmpty()){
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode tmp = q.poll();
//                tmpList.add(tmp.val);
//                if (tmp.val == Integer.MIN_VALUE)continue;
//                if (tmp.left!=null)
//                    q.add(tmp.left);
//                else q.add(new TreeNode(Integer.MIN_VALUE));
//                if (tmp.right!=null)
//                    q.add(tmp.right);
//                else q.add(new TreeNode(Integer.MIN_VALUE));
//            }
//            list.add(new ArrayList<>(tmpList));
//            tmpList.clear();
//        }
//        for (int i = 0; i < list.size(); i++) {
//            List<Integer> tmp = new ArrayList<>(list.get(i));
//            Collections.reverse(list.get(i));
//            if (!list.get(i).equals(tmp))return false;
//        }
//        return true;
//    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return _isSymmetric(root.left,root.right);
    }

    private boolean _isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val
                && _isSymmetric(root1.left, root2.right)
                && _isSymmetric(root1.right, root2.left);
    }
    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null)return resList;
        backTracking(root,sum,new LinkedList<>(),resList);
        return resList;
    }
    public void backTracking(TreeNode root,int sum,LinkedList<Integer> cur,List<List<Integer>>res){
        if (root == null)return;
        sum -=root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            cur.addLast(root.val);
            res.add(new ArrayList<>(cur));
            cur.removeLast();
            return;
        }
        cur.addLast(root.val);
        backTracking(root.left,sum,cur,res);
        backTracking(root.right,sum,cur,res);
        cur.removeLast();
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