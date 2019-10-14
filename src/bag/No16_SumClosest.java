package bag;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author YoSaukit
 * @date 2019/10/14 19:29
 */
public class No16_SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        No16_SumClosest no16_sumClosest = new No16_SumClosest();
        System.out.println(no16_sumClosest.threeSumClosest(nums,target));
    }

    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                }else{
                    start++;
                }
                if (Math.abs(sum - target)<Math.abs(result-target)){
                    result = sum;
                }
            }
        }
        return result;
    }
}
