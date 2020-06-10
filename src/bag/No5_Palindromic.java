package bag;

/**
 * @author YoSaukit
 * @date 2019/10/8 19:52
 */
public class No5_Palindromic {
    private int lo, maxLen;

    public static void main(String[] args) {
        No5_Palindromic no5_palindromic = new No5_Palindromic();
        System.out.println(no5_palindromic.longestPalindrome("babad"));
    }

    //两侧扩展
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len<2)return s;
//        for (int i = 0; i < len - 1; i++) {
//            extendPalidrome(s,i,i);
//            extendPalidrome(s,i,i+1);
//        }
//        return s.substring(lo,lo+maxLen);
//    }
//    private void extendPalidrome(String s, int j, int k){
//        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
//            j--;
//            k++;
//        }
//        if (maxLen<k-j-1){
//            lo = j+1;
//            maxLen = k-j-1;
//        }
//    }
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int max_len = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (j + 1 == i && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && s.charAt(i) == s.charAt(j);
                }
                if (dp[j][i] && i - j + 1 > max_len) {
                    max_len = i - j + 1;
                    start = j;
                }
            }
        }
        String res = new String(s.toCharArray(),start,max_len);
        return res;
    }
}
