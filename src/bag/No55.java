package bag;

/**
 * @author YoSaukit
 * @date 2020/4/17 23:47
 */
public class No55 {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost,i+nums[i]);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
