package bag;

/**
 * @author YoSaukit
 * @date 2019/11/17 20:23
 */
public class No42_TrappingRainWater {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int sum = 0;
        int left = 0,right = height.length-1;
        int maxLeft = Integer.MIN_VALUE,maxRight = Integer.MIN_VALUE;
        while (left < right) {
            maxLeft = Math.max(maxLeft,height[left]);
            maxRight = Math.max(maxRight,height[right]);
            if (maxLeft < maxRight){
                sum += maxLeft-height[left++];
                maxLeft = Math.max(maxLeft,height[left]);
            }else{
                sum += maxRight-height[right--];
                maxRight = Math.max(maxRight,height[right]);
            }
        }
        return sum;
    }

}
