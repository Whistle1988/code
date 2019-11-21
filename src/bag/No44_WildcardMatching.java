package bag;

/**
 * @author YoSaukit
 * @date 2019/11/21 9:44
 */
public class No44_WildcardMatching {
    public static void main(String[] args) {
        No44_WildcardMatching no44_wildcardMatching = new No44_WildcardMatching();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(no44_wildcardMatching.isMatch(s, p));

    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*')
                dp[0][i + 1] = dp[0][i];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
