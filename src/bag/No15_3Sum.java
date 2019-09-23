package bag;

import java.util.*;

public class No15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        No15_3Sum no15_3Sum = new No15_3Sum();
        System.out.println(Arrays.toString(no15_3Sum.threeSum(nums).toArray()));
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length == 0)return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>0)k--;
                else if (sum<0)j++;
            }
        }
        return new ArrayList<>(res);
    }
}
