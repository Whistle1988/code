package targetOffer.netease;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 16:22
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            int tmp = in.nextInt();
            A[i] = tmp;
        }
        int result = 1;
        Arrays.sort(A);
        for (int i = 0; i < n - 1 && k >= 0; i++) {
            if (A[i] == 0) {
                k -= 1;
                result++;
            } else {
                k -= A[i];
            }
        }
        System.out.println(result);
    }
}
