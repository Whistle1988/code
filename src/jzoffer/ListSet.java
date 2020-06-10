package jzoffer;

import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2020/5/19 12:18
 */
public class ListSet {


    /**
     * 合并两个排序的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode t = new ListNode(0);
        ListNode l3 = t;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while (l1 == null) {
            l3.next = l2;
        }
        while (l2 == null) {
            l3.next = l1;
        }
        return t.next;
    }
    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)return null;
        ListNode pre = null,cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;

        }
        return pre;
    }

    /**
     * 删除链表的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode f = head;
        while (f.next.val != val) {
            f = f.next;
        }
        if (f.next.next==null){
            f.next = null;
        }else{
            f.next = f.next.next;
        }
        return head;
    }

    /**
     * 从尾到头打印链表
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        int cnt = 0;
        while (!s.isEmpty()) {
            res[cnt++] = s.pop();
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
