package LinkedList;

//  definition for singly-linked list.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), head = l;
        int t = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + t;
            t = sum / 10;
            sum = sum % 10;
            l.next = new ListNode(sum);
            l = l.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (t == 1) {
            l.next = new ListNode(t);
        }
        return head.next;
    }

    //最高为在链表头
    public ListNode _addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while (!s1.empty() || !s2.empty() || carry > 0) {
            int sum = carry;
            sum += s1.empty() ? 0 : s1.pop();
            sum += s2.empty() ? 0 : s2.pop();
            //***********链表头插法*************
            ListNode tmp = new ListNode(sum);
            tmp.next = res;
            res = tmp;
            carry = sum / 10;
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) end--;
                else if (sum < target) start++;
                else return ans;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int tmp = nums[start] + nums[end] + nums[i];
                if (tmp < 0) start++;
                else if (tmp > 0) end--;
                else {
                    res.add(Arrays.asList(nums[start], nums[end], nums[i]));
                    while (start < end && nums[start + 1] == nums[start]) start++;
                    while (start < end && nums[end - 1] == nums[end]) end--;
                    start++;
                    end--;
                }
            }
        }
        return res;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode h = head;
        if (head == null || k == 0) return head;
        int len = 1;
        while (h.next != null) {
            h = h.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode s = head;
        for (int i = 0; i < len - k - 1; i++) {
            s = s.next;
        }
        ListNode x = s.next;
        s.next = null;
        h.next = head;
        return x;

    }

    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) return false;
        return false;
    }

    public static void main(String[] args) {
        DeleteNode dn = new DeleteNode();
        dn.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
