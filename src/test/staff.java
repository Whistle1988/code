package test;

import java.util.List;
import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

public class staff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int m = 0; m < t; m++) {

            int sum = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[100001];
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            int mid = sum / 2;
            for (int i = 0; i < n; i++) {
                for (int j = mid; j >= arr[i]; j--) {
                    dp[j] = max(dp[j], dp[j - arr[i]] + arr[i]);
                }
            }
            if (dp[mid] < sum - dp[mid]) {
                System.out.println(dp[mid] + " " + (sum - dp[mid]));
            } else {
                System.out.println((sum - dp[mid]) + " " + dp[mid]);
            }
        }

    }
}
