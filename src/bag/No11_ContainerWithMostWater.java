package bag;


import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author YoSaukit
 * @date 2019/10/14 10:04
 */
public class No11_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,7};
        No11_ContainerWithMostWater no11_containerWithMostWater = new No11_ContainerWithMostWater();
        System.out.println(no11_containerWithMostWater.maxArea(height));
    }
    public int maxArea(int[] height) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int index=0,max=0;
        while (index < height.length-1) {
            for (int i = index+1; i < height.length; i++) {
                max = (i-index)*min(height[i],height[index])>max?(i-index)*min(height[i],height[index]):max;
            }
            index++;
            arrayList.add(max);
        }
        arrayList.sort(Comparator.reverseOrder());
        return arrayList.get(0);
    }
    //more efficient
    public int maxArea1(int[] height) {
        int left = 0,right = height.length-1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if (height[left] < height[right])
                left++;
            else right--;
        }
        return maxArea;
    }
}
