package bag;

import java.util.Arrays;

/**
 * @author YoSaukit
 * @date 2019/10/18 21:09
 */
public class No27_RemoveElement {
    No26_RemoveDuplicates no26_removeDuplicates = new No26_RemoveDuplicates();

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int begin=0;
        for(int i=0;i<nums.length;i++) if(nums[i]!=val) nums[begin++]=nums[i];
        return begin;
    }


}
