package bag;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class No1_twoSum {
    public static void main(String[] args) {
        int []nums = {2,7,11,15};
        int target = 9;
        No1_twoSum no1_twoSum = new No1_twoSum();
        System.out.println( Arrays.toString(no1_twoSum.twoSum(nums,target)));
    }
    public int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(target-nums[i]>0){
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]==target-nums[i]){
                        arr[0]=i;
                        arr[1]=j;
                    }
                }
            }
        }
        return arr;
    }

}
