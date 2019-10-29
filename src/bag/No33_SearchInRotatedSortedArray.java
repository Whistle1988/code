package bag;

/**
 * @author YoSaukit
 * @date 2019/10/29 9:50
 */
public class No33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int target = 2;
        No33_SearchInRotatedSortedArray no33_searchInRotatedSortedArray =  new No33_SearchInRotatedSortedArray();
        System.out.println(no33_searchInRotatedSortedArray.search(nums,target));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0||nums==null)return -1;
        return search(nums,0,nums.length-1,target);
    }
    public int search(int[] nums,int start,int end,int target){
        int mid = (start+end)/2;
        int result=-1;
        if (nums[mid]==target){
            return mid;
        }
        if (start == end||end<0||start>nums.length||start>end)return result;
        if (nums[mid]>=nums[start]){
            if (nums[start]<=target&&target<=nums[mid]){
                result = search(nums,start,mid-1,target);
            }else
                result = search(nums,mid+1,end,target);
        }else{
            if (nums[mid]<=target&&target<=nums[end]){
                result = search(nums,mid+1,end,target);
            }else{
                result = search(nums,start,mid-1,target);
            }
        }
        return result;
    }

}
