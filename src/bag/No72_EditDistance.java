package bag;

/**
 * @author YoSaukit
 * @date 2020/2/4 17:46
 */
public class No72_EditDistance {
    public static void main(String[] args) {
        No72_EditDistance editDistance = new No72_EditDistance();
        System.out.println(editDistance.minDistance("horse","ros"));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else{
                    int a = dp[i][j];
                    int b = dp[i][j+1];
                    int c = dp[i+1][j];
                    dp[i+1][j+1] = 1 + Math.min(a,Math.min(b,c));
                }

            }
        }
        return dp[m][n];
    }
}
