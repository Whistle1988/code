package bag;

import java.util.List;
import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2019/9/28 17:51
 */
public class No2_AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0;
        while(l1!=null||l2!=null||tmp!=0){
            if (l1!=null){
                tmp+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                tmp+=l2.val;
                l2=l2.next;
            }
            p.next = new ListNode(tmp%10);
            p = p.next;
            tmp/=10;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
