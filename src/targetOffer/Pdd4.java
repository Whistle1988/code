package targetOffer;

import java.util.HashSet;
import java.util.Scanner;

public class Pdd4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] A = new int[m];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            A[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % A[j] == 0) {
                    set.add(i);
                }
            }
        }
        System.out.println(set.size());
    }
}
