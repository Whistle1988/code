package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/10/15 19:43
 */
public class No18_4Sum {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        No18_4Sum no18_4Sum = new No18_4Sum();
        no18_4Sum.fourSum(nums,target);
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n1,n2;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] part = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            part[i] = target-nums[i];
        }

        int index=0;
        while(index<nums.length-3){
            for (int i = index+1; i < nums.length-2; i++) {
                n1=i+1;
                n2=nums.length-1;
                while(n1<n2){
                    if (nums[i]+nums[n1]+nums[n2]==part[index]){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[index]);
                        list.add(nums[i]);
                        list.add(nums[n1]);
                        list.add(nums[n2]);
                        if (!res.contains(list)){
                            res.add(list);
                        }
                        n1++;
                        n2--;
                    }else if (nums[i]+nums[n1]+nums[n2]<part[index]){
                        n1++;
                    }else
                        n2--;
                }
            }
            index++;
        }
        return res;
    }
}
