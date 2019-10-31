package bag;

/**
 * @author YoSaukit
 * @date 2019/10/30 20:43
 */
public class No35_SearchInsertPostion {
    public static void main(String[] args) {
        No35_SearchInsertPostion no35_searchInsertPostion = new No35_SearchInsertPostion();
        int[] nums = {1};
        int target = 1;
        System.out.println(no35_searchInsertPostion.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

}
