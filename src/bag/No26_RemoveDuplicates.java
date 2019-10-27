package bag;

/**
 * @author YoSaukit
 * @date 2019/10/18 21:02
 */
public class No26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        No26_RemoveDuplicates no26_removeDuplicates = new No26_RemoveDuplicates();
        System.out.println(no26_removeDuplicates.removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length==0||nums==null) return 0;
        int i=0,j=1;
        while (i < nums.length&&j<nums.length) {
            if (nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
                j++;
            }
        }
        return i+1;
    }
}
