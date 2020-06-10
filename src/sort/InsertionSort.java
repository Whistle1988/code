package sort;

/**
 * @author YoSaukit
 * @date 2020/3/24 17:26
 */
public class InsertionSort {
    public static int[] insertionSort(int[] ins) {

        for (int i = 1; i < ins.length; i++) {
            int temp = ins[i];//保存每次需要插入的那个数
            int j;
            for (j = i; j > 0 && ins[j - 1] > temp; j--) {//这个较上面有一定的优化
                ins[j] = ins[j - 1];//把大于需要插入的数往后移动。最后不大于temp的数就空出来j
            }
            ins[j] = temp;//将需要插入的数放入这个位置
        }
        return ins;
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 6, 7, 2, 3};
        insertionSort(arr);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head,cur = head.next;
        ListNode aux = new ListNode(-1);
        aux.next = head;
        while (cur != null) {
            if (cur.val < pre.val){
                //先把cur摘下来
                pre.next = cur.next;
                ListNode l1 = aux,l2 = aux.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                l2.next = cur;
                cur.next = l2;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}