package targetOffer.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/6 21:06
 */
public class Test4 {
    public static int[] findMid(int n, int[] A, int[] B) {
        int left = n / 2 - 1, right = n / 2;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] <= B[left]) {
                result[i] = B[right];
            } else {
                result[i] = B[left];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int[] B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        int[] result = findMid(n, A, B);
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
