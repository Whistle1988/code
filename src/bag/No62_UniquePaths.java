package bag;

/**
 * @author YoSaukit
 * @date 2019/12/24 21:22
 */
public class No62_UniquePaths {
    public static void main(String[] args) {
        No62_UniquePaths uniquePaths = new No62_UniquePaths();
        uniquePaths.uniquePaths(3,3);
    }

    //如果按行来计算的话，计算每一行的路径数仅需要知道上一行的路径数即可，那么是否可以只保存上一行的路径数
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];
    }
    public int uniquePaths2D(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
