package targetOffer.jd;

import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/17 19:39
 */
public class Test2 {
    static boolean result = false;
    static boolean[][] isVisited;

    public static void judge(char[][] A, int sX, int sY, int eX, int eY) {
        if (result || (sX == eX && sY == eY)) {
            result = true;
            return;
        }
        if (sX < 0 || sY < 0 || sX > A.length - 1 || sY > A[0].length - 1 || A[sX][sY] == '#' || isVisited[sX][sY]) {
            return;
        }
        isVisited[sX][sY] = true;
        judge(A, sX + 1, sY, eX, eY);
        judge(A, sX - 1, sY, eX, eY);
        judge(A, sX, sY + 1, eX, eY);
        judge(A, sX, sY - 1, eX, eY);
        isVisited[sX][sY] = false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int group = in.nextInt();
        while (group > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int sX = 0, sY = 0, eX = 0, eY = 0;
            char[][] A = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == 'S') {
                        sX = i;
                        sY = j;
                    }
                    if (s.charAt(j) == 'E') {
                        eX = i;
                        eY = j;
                    }
                    A[i][j] = s.charAt(j);
                }
            }
            isVisited = new boolean[n][m];
            judge(A, sX, sY, eX, eY);
            String r = result ? "YES" : "NO";
            System.out.println(r);
            result = false;
            group--;
        }
    }
}
