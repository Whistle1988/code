package bag;

/**
 * @author YoSaukit
 * @date 2019/9/25 15:11
 */
public class No70_ClimbingStairs {
    public static void main(String[] args) {
        No70_ClimbingStairs no70_climbingStairs = new No70_ClimbingStairs();
        System.out.println(no70_climbingStairs.climbStairs(3));
    }
    public int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



}
