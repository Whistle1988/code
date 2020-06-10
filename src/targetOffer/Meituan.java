package targetOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author YoSaukit
 * @date 2020/4/16 18:57
 */
public class Meituan {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int a, b, m, x;
        a = cin.nextInt();
        b = cin.nextInt();
        m = cin.nextInt();
        x = cin.nextInt();
        int[] A = new int[10000];
        int index = 0;
        while (index<10000) {
            x = (a * x + b) % m;
            A[index] = x;
            index++;
        }
        int i = 0,j = -1;


    }
}
