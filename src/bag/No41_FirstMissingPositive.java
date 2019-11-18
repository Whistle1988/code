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
        int i=0;
        while(i<nums.length){
            if (nums[i]>=1&&nums[i]<=nums.length&&nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }else
                i++;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]!=j+1)return j+1;
        }
        return nums.length+1;
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
