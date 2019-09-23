package LinkedList;

public class RemoveNth {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int num = 0;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            temp = temp.next;
            num++;
        }
        temp = head;
        n = num - n;
        if (n == 0) {
            head = head.next;
            return head;
        }
        int i = 0;
        while (temp != null && i != n) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        return head;
    }
}
