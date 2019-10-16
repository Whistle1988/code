package summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/10/16 9:51
 */
public class kSum {
    private static int len = 0;

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        kSum kSum = new kSum();
        kSum.kSum(nums,target,4,0);
    }
    private ArrayList<List<Integer>> kSum(int[] nums,int target,int k,int index){
        len=nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (index>=len) return res;
        if (k == 2) {
            int i=index,j=len-1;
            while (i < j) {
                if (target - nums[i] == nums[j]){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(target-nums[i]);
                    res.add(tmp);
                    //skip duplication
                    while(i<j && nums[i] == nums[i+1])i++;
                    while(i<j && nums[j] == nums[j-1])j--;
                    i++;
                    j--;
                }else if (target-nums[i]>nums[j]){
                    i++;
                }else
                    j--;
            }
        }else{
            for (int i = index; i < len-k+1; i++) {
                ArrayList<List<Integer>> tmp = kSum(nums,target-nums[i],k-1,i+1);
                if (tmp != null) {
                    for (List<Integer>t: tmp){
                        t.add(0, nums[i]);
                    }
                    res.addAll(tmp);
                }
                //skip duplicate numbers
                while(i<len-1&&nums[i]==nums[i+1]){
                    i++;
                }

            }
        }
        return res;
    }
}
