package targetOffer;

import java.util.Scanner;

public class Pdd3 {

    public static int backpack(int m, int[] A, int[] V) {
        int[] f = new int[A.length];
        int best = 0;
        for (int i = 1; i <= A.length; i++) {
            if (A[i] > 0) {
                for (int j = m - 1; j >= A[i]; j--) {
                    f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
                }
            } else {
                A[i] = -A[i];
                for (int j = 0; j + A[i] < m; j++) {
                    f[j] = Math.max(f[j], f[j + A[i]] + V[i]);
                }
            }
        }
        return f[A.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[n];
        int[] V = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
            V[i] = in.nextInt();
        }
        System.out.println(backpack(m, A, V));
    }

}
