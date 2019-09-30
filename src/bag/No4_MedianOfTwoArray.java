package bag;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YoSaukit
 * @date 2019/9/30 18:37
 */
public class No4_MedianOfTwoArray {
    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        No4_MedianOfTwoArray no4_medianOfTwoArray = new No4_MedianOfTwoArray();
        System.out.println(no4_medianOfTwoArray.findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (i< nums1.length) nums[i]=nums1[i];
            else nums[i] = nums2[i-nums1.length];
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());

        if (list.size()%2==0) return (list.get(list.size()/2-1)+list.get(list.size()/2))/2.0;
        else return list.get(list.size()/2)/1.0;
    }
}
