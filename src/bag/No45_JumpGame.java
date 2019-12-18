package bag;

/**
 * @author YoSaukit
 * @date 2019/12/11 10:24
 */
public class No45_JumpGame {
    public int jump(int[] nums) {
        if (nums.length==1)return 0;
        int res = 1,index = 0;
        return _jump(nums,index,res);
    }
    public int _jump(int[] nums,int index,int res){
        if (nums[index] >= nums.length-index-1)return res;
        else{
            int x = nums[index+1],y=index+1;
            for (int i = index+1; i < Math.min(index+nums[index]+1,nums.length) ; i++) {
                if (x+y<=nums[i]+i){
                    x = nums[i];
                    y = i;
                }
            }
           return _jump(nums,y,++res);
        }
    }

    public static void main(String[] args) {
        No45_JumpGame no45_jumpGame = new No45_JumpGame();
        int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
        System.out.println(no45_jumpGame.jump(nums));
    }
}
