package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/11/5 22:31
 */
public class No41_FirstMissingPositive {
    public static void main(String[] args) {
        No41_FirstMissingPositive no41_firstMissingPositive = new No41_FirstMissingPositive();
        int[] nums = {1,2,0};
        System.out.println(no41_firstMissingPositive.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int flag;
        if (nums[0]>1){
            return 1;
        }else{
            flag=1;
        }
        list.add(nums[nums.length-1]);
        for (int i = nums.length-2; i >0 ; i--) {
            if (!list.contains(nums[i]+1))
        }
    }
}
