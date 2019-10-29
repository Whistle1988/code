package bag;

import java.util.*;

/**
 * @author YoSaukit
 * @date 2019/10/29 10:46
 */
public class No34_FindPostition {
    public static void main(String[] args) {
        No34_FindPostition no34_findPostition = new No34_FindPostition();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(no34_findPostition.searchRange(nums,target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ranges = {nums.length,-1};
        searchIndex(nums,0,nums.length-1,target,ranges);
        if (ranges[0]>ranges[1])ranges[0]=-1;
        return ranges;
    }
    public void searchIndex(int[] nums,int start,int end,int target,int[] ranges){
        int mid = (start+end)/2;
        if (start > end){
            return;
        }
        if (nums[mid]==target){
            if (mid < ranges[0]) {
                ranges[0] = mid;
                searchIndex(nums,start,mid-1,target,ranges);
            }
            if (mid>ranges[1]){
                ranges[1]=mid;
                searchIndex(nums,mid+1,end,target,ranges);
            }
        }else if(nums[mid]<target){
            searchIndex(nums,mid+1,end,target,ranges);
        }else
            searchIndex(nums,start,mid-1,target,ranges);

    }
}
