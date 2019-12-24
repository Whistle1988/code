package bag;

/**
 * @author YoSaukit
 * @date 2019/12/24 20:27
 */
public class No61_RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||k==0) return head;
        ListNode fast = head;
        ListNode slow = head;
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        k = k%n;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }
}
