package bag;

import java.util.Arrays;

/**
 * @author YoSaukit
 * @date 2019/10/27 21:09
 */
public class No31_nextPermutation {
    public static void main(String[] args) {
        No31_nextPermutation no31_nextPermutation = new No31_nextPermutation();
        int[] nums = {1,3,2};
        no31_nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        int p = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }
        if (p==-1){
            reverse(nums,0,nums.length-1);
        }
        else{
            for (int i = nums.length-1; i >= 0; i--) {
                if (nums[p]<nums[i]){
                    swap(nums,p,i);
                    break;
                }
            }
            reverse(nums,p+1,nums.length-1);
        }


    }
    public void swap(int[] nums,int p,int q){
        int a = nums[p];
        nums[p] = nums[q];
        nums[q] = a;
    }
    public void reverse(int[] nums,int start,int end){
        for (int i = start; i <= (end+start)/2; i++) {
            swap(nums,i,start+end-i);
        }
    }
}
