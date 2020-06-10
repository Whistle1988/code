package targetOffer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author YoSaukit
 * @date 2020/4/20 16:32
 */
public class Baidu {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N, a,b,c;
        N = cin.nextInt();
        a = cin.nextInt();
        b = cin.nextInt();
        c = cin.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = cin.nextInt();
        }
        int max = 0;
        int cost = 2;
        for (int i = 0; i < N; i++) {
            if (max>=N){
                System.out.println(cost);
                return;
            }else{
                max = Math.max(max,i+A[i]);
                cost+=b;
            }
        }

    }
}
