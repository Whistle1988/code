package bag;

/**
 * @author YoSaukit
 * @date 2019/10/16 11:39
 */
public class No23_MergeKSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists,0, lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists,int start,int end){
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists,start,mid);
            ListNode right = mergeKLists(lists,mid+1,end);
            return mergeTwoLists(left,right);
        }else return null;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l3 = result;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;
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
        if (l1!= null) {
            l3.next = l1;
        }else if (l2!= null) {
            l3.next = l2;
        }
        return result.next;
    }


}
