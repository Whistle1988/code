package targetOffer.vivo;

import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 20:02
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            for (int j = 0; j < n; j++) {
                char ch = str.charAt(j);
                if (ch == '#' || ch == '@') {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        if (A[x1][y1] == 0 || A[x2][y2] == 0) {
            System.out.println(-1);
            return;
        }
        int[][] dp = new int[x2 - x1 + 1][y2 - y1 + 1];
        dp[0][0] = 0;
        for (int i = x1 + 1; i <= x2 && A[i][y1] != 0; i++) {
            dp[i - x1][0] = dp[i - 1][0] + 1;
        }
        for (int i = y1 + 1; i <= y2 && A[i][x1] != 0; i++) {
            dp[0][i - y1] = dp[0][i - y1 - 1] + 1;
        }
        for (int i = x1 + 1; i <= x2; i++) {
            for (int j = y2 + 1; j <= y2; j++) {
                if (A[i][j] != 0) {
                    dp[i - x1][j - y1] = Math.min(dp[i - x1 - 1][j - y1], Math.min(dp[i - x1 + 1][j - y1]
                            , Math.min(dp[i - x1][j - y1 - 1], dp[i - x1][j - y1 + 1])));
                }
            }
        }
        System.out.println(dp[x2 - x1][y2-y1]);
    }
}
