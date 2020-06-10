package LinkedList;

/**
 * @author YoSaukit
 * @date 2020/4/20 21:39
 */
//反转链表
//迭代法
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    //尾递归
    public ListNode _reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = _reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}



class ListNode {
    ListNode next;
    int val;

    public ListNode(int x) {
        val = x;
    }
}