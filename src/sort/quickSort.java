package sort;


import java.util.Stack;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        //跳出循环时low和high相等，此时low和high都是正确争取索引位置
        arr[low] = tmp;
        return low;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //基于链表的快速排序
    public ListNode quickSort(ListNode begin, ListNode end) {
        if (begin == null || end == null || begin == end) {
            return begin;
        }
        ListNode first = begin;
        ListNode second = begin.next;
        int nMidValue = begin.val;
        //second到最后
        while (second != end.next && second != null) {
            //一直往后寻找<= nMidValue 的节点，然后与fir的后续节点交换
            if (second.val < nMidValue) {
                first = first.next;
                //判断一下，避免后面的数比第一个数小，不用换的局面
                if (first != second) {
                    int temp = first.val;
                    first.val = second.val;
                    second.val = temp;
                }
            }
            second = second.next;
        }
        quickSort(begin, first);
        quickSort(first.next, end);
        return begin;
    }

    //非递归实现
    public void qSort(int[] a, int low, int high) {
        int pivot;
        if (low >= high) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            pivot = getIndex(a, low, high);
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }
}
