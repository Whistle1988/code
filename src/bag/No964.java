package bag;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YoSaukit
 * @date 2020/3/19 15:51
 */
public class No964 {
    public int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted((o1, o2) -> 0).collect(Collectors.toList());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x == 0 && y == 0) return z == 0;
        return z == 0 || (z % gcd(x, y) == 0 && x + y >= z);
    }

    static int gcd(int x, int y) {
        if (y == 0) return x;
        int r = x % y;
        return gcd(y, r);
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    char tmp = stack.pop();
                    if (tmp == '(' && ch != ')'
                            || tmp == '{' && ch != '}'
                            || tmp == '[' && ch != ']')
                        return false;
                }

            }
        }
        if (!stack.isEmpty()) return false;
        else return true;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> numList = new ArrayList<>(res.get(i));
                numList.add(n);
                res.add(numList);
            }
        }
        return res;
    }

    public int[][] generateMatrix(int n) {
        return generate(new int[n][n], 0, n, 1);
    }

    public int[][] generate(int[][] res, int a, int b, int tmp) {
        if (a >= b) return res;
        for (int i = a; i < b; i++) {
            res[a][i] = tmp++;
            if (i == b - 1) {
                for (int j = a + 1; j < b; j++) {
                    res[j][i] = tmp++;
                    if (j == b - 1) {
                        for (int k = b - 2; k >= a; k--) {
                            res[j][k] = tmp++;
                            if (k == a) {
                                for (int l = b - 2; l >= a + 1; l--) {
                                    res[l][a] = tmp++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return generate(res, a + 1, b - 1, a);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        return order(new ArrayList<>(), matrix, 0, matrix.length, 0, matrix[0].length);
    }

    public List<Integer> order(List<Integer> res, int[][] matrix, int up, int down, int left, int right) {
        if (up >= down) return res;
        for (int i = left; i < right; i++) {
            res.add(matrix[up][i]);
            if (i == right - 1) {
                for (int j = up + 1; j < down; j++) {
                    res.add(matrix[j][i]);
                    if (j == down - 1) {
                        for (int k = right - 2; k >= left; k--) {
                            res.add(matrix[j][k]);
                            if (k == left) {
                                for (int l = down - 2; l > up; l--) {
                                    res.add(matrix[l][left]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return order(res, matrix, up + 1, down - 1, left + 1, right - 1);
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //链表归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //链表长度
        int len = listNodeLength(head);
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        for (int i = 0; i < len; i <<= 1) {
            ListNode prev = sentry;
            ListNode curr = sentry.next;
            //循环n次
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, i);
                curr = split(right, i);
                prev.next = mergeTwoLists(left, right);
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return sentry.next;
    }

    //按步长分割链表
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        return right;
    }

    private int listNodeLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        return length;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(-1);
        ListNode curr = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return sentry.next;
    }

    public int search(int[] nums, int target) {
        return _search(nums, target, 0, nums.length - 1);
    }

    public int _search(int[] nums, int target, int left, int right) {
        int mid = (right - left) / 2 + left;
        while (left <= right) {
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode tmp = head;
        int len = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode node = head;
        for (int i = 0; i < len - k - 1; i++) {
            node = node.next;
        }
        ListNode newHead = node.next;
        tmp.next = head;
        node.next = null;
        return newHead;
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            for (int j = strs[i].length() - 1; j >= 0; j--) {
                sb.append(strs[i].charAt(j));
            }
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

    public void reverseString(char[] s) {
        int len = s.length;
        int i = 0, j = s.length - 1;
        while (i != j && i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }

    //*******************************************************
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }

    List<List<Integer>> lists = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        visited = new boolean[nums.length];
        process(list, nums);
        return lists;
    }

    private void process(List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                process(list, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();

    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
        if (leftCommonAncestor == null) return rightCommonAncestor;
        if (rightCommonAncestor == null) return leftCommonAncestor;
        return root;
    }

    /**
     * BFS求最短路径
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                }
                if (r + 1 < N && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < N && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
        return distance;
    }

//    public static void main(String[] args) {
//        No964 no = new No964();
////        int[][] matrix = {
////                {1,2,3},{4,5,6}
////        };
////        System.out.println(no.spiralOrder(matrix));
////        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println();
//    }

    /**
     * 第一次相遇，slow = nb
     * a + nb = 入口点
     * slow再走a = 入口 = head走到入口 = a
     * 由3得出，起始距离入口 = 第一次相遇位置 + a
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("()");
        return sub(n, list);
    }

    public List<String> sub(int n, List<String> res) {
        List<String> list = new ArrayList<>();
        if (res.get(0).length() == n * 2) return res;
        for (String s :
                res) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(s, 0, i + 1);
                sb.append("()");
                sb.append(s.substring(i + 1));
                if (!list.contains(sb.toString())) list.add(sb.toString());
            }
        }
        return sub(n, list);

    }



    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>();

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public List<Integer> grayCode(int n) {
        List<Integer> gray = new ArrayList<>();
        gray.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = gray.size() - 1; j >= 0; j--) {
                gray.add(gray.get(j) + add);
            }
        }
        return gray;
    }

    public int maxArea(int[] height) {
//        int res = Integer.MIN_VALUE,tmp = 0;
//        for (int i = 1; i < height.length; i++) {
//            for (int j = 0; j < i; j++) {
//                tmp = (i-j)*Math.min(height[i],height[j]);
//                if (tmp>res)res = tmp;
//            }
//        }
//        return res;
        int i = 0,j = height.length-1,res = 0;
        while (i < j) {
            res = height[i] < height[j]?Math.max(res,(j-i)*height[i++]):Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        No964 test = new No964();
        System.out.println(test.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
//    public int reversePairs(int[] nums) {
//
//    }
}


