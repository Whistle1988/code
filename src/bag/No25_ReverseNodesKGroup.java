package bag;

/**
 * @author YoSaukit
 * @date 2019/10/17 11:15
 */
public class No25_ReverseNodesKGroup {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11413/Share-my-Java-Solution-with-comments-in-line
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), start = dummy;
        dummy.next = head;
        while (true) {
            ListNode p = start, c, n = p;
            start = p.next;
            for (int i = 0; i < k && n != null; i++) {
                n = n.next;
            }
            if (n == null) break;
            for (int i = 0; i < k - 1; i++) {
                c = p.next;
                p.next = c.next;
                c.next = n.next;
                n.next = c;
            }
        }
        return dummy.next;
    }


}
