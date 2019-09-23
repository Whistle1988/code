package test;

import static sun.swing.MenuItemLayoutHelper.max;

public class StaffAver {
    public void aver(int []arr){
        int[] dp = new int[100001];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int mid = sum / 2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = mid; j >= arr[i]; j--) {
                dp[j] = max(dp[j], dp[j - arr[i]] + arr[i]);
            }
        }
        if (dp[mid]<sum-dp[mid]){
            System.out.println(dp[mid]+" "+(sum-dp[mid]));
        }else{
            System.out.println((sum-dp[mid])+" "+dp[mid]);
        }
    }

}



