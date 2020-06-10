package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * dp系列 279 300 309 312
 *
 * @author YoSaukit
 * @date 2020/4/18 21:46
 */
public class DP {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        int i = 1;
        List<Integer> list = new ArrayList<>();
        while (i < sqrt + 1) {
            list.add(i * i);
            i++;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j < n + 1; j++) {
            for (Integer sub :
                    list) {
                if (j < sub) {
                    break;
                }
                dp[j] = Math.min(dp[j], dp[j - sub] + 1);
            }
        }
        return dp[n];
    }

    //300 O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //300 O(nlogn) 贪心+二分查找
    public int _lenthOfLIS(int[] nums){
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        //长度为i+1的上升子序列的末尾最小是几
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]){
                end++;
                tail[end] = nums[i];
            }else{
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = left+(right-left)/2;
                    if (tail[mid]<nums[i]){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
    //309
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0,dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;//dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,dp_pre_0-prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
    //312
    //https://leetcode-cn.com/problems/burst-balloons/solution/java-dong-tai-gui-hua-xiao-bai-si-kao-guo-cheng-fe/
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        int[][] dp = new int[newNums.length][newNums.length];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i+1] = nums[i];
        }
        return maxCoins(newNums,0,newNums.length-1,dp);
    }
    public int maxCoins(int[] nums,int start,int end,int[][] dp){
        if (end - start == 1)return 0;
        if (dp[start][end] != 0)return dp[start][end];
        int max = 0;
        for (int i = start+1; i < end; i++) {
            max = Math.max(nums[i]*nums[start]*nums[end]+maxCoins(nums,start,i,dp)+maxCoins(nums,i,end,dp),max);
        }
        dp[start][end] = max;
        return max;
    }
    public static void main(String[] args) {
        DP dp = new DP();
        System.out.println(dp.maxProfit(new int[]{1,2,3,0,2}));
    }
}
