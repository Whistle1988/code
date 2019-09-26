package bag;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YoSaukit
 * @date 2019/9/26 15:35
 */
public class No88_MergeSortedArray {
    public static void main(String[] args) {
        No88_MergeSortedArray no88_mergeSortedArray = new No88_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        no88_mergeSortedArray.merge(nums1,m,nums2,n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int k = 0;
        for (int i = m ; i < m + n; i++) {
            nums1[i] = nums2[k++];
        }
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = list.get(i);
        }
        System.out.println(Arrays.toString(nums1));

    }
}
