package summary;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2020/4/9 10:31
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public class Tree {

        //二叉搜索树转换成排序的循环双向链表
        //1. 排序链表：节点从小到大排序，中序遍历
        //2. 双向链表，相邻节点：pre.right = cur,cur.left = pre
        //3. 循环链表，头尾节点head,head.left = tail,tail.right = head'
        Node pre = new Node(0), head = pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            dfs(root);
            head = head.right;
            head.left = pre;
            pre.right = head;
            return head;
        }

        public void dfs(Node cur) {
            if (cur == null) return;
            dfs(cur.left);
            pre.right = cur;
            cur.left = pre;
            pre = cur;
            dfs(cur.right);
        }

        //二叉树的最大路径和 递归
        int max = Integer.MIN_VALUE;

        public int maxPathSum(Node root) {
            if (root == null) {
                return 0;
            }
            _dfs(root);
            return max;
        }

        public int _dfs(Node root) {
            if (root == null) return 0;
            int leftMax = Math.max(0, _dfs(root.left));
            int rightMax = Math.max(0, _dfs(root.right));
            max = Math.max(max, root.val + leftMax + rightMax);
            return root.val + Math.max(leftMax, rightMax);
        }
    }

    //递归实现前序遍历
    void binaryTreePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        binaryTreePreOrder(root.left);
        binaryTreePreOrder(root.right);
    }

    //非递归实现前序遍历（借助栈）
    void binaryTreePreOrderNonR(Node root) {
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.println(cur.val + " ");
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
    }

    //后序遍历
    //递归算法中，利用栈回退时，并不知道是从左子树回退到根节点，
    //还是从右子树回退到根节点。所以相比前序遍历，必须在压栈时添加信息，
    //以便在退栈时可以知道是从左子树返回，还是从右子树返回。
    void postOrder(Node root) {
        int left = 1, right = 2;
        Stack<Node> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                stack1.push(left);
                cur = cur.left;
            }
            while (!stack.isEmpty() && stack1.peek() == right) {
                stack1.pop();
                System.out.println(stack.pop().val);
            }
            if (!stack.isEmpty() && stack1.peek() == left) {
                stack1.pop();
                stack1.push(right);
                cur = stack.peek().right;
            }
        }
    }

    //层次遍历（队列）
    void levelTraversal(Node root) {
        if (root == null)return;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        Node cur;
        while (!list.isEmpty()) {
            cur = list.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                list.add(cur.left);
            }
            if (cur.right != null) {
                list.add(cur.right);
            }
        }
    }
}
