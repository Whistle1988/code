package targetOffer.iqiyi;

import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/13 15:32
 */
public class Test2 {
    public static int majorityElement(int[] A){
        int count = 1;
        int maj = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maj == A[i]){
                count++;
            }else{
                count--;
                if (count == 0){
                    maj = A[i+1];
                }
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strings = str.split(" ");
        int[] A = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            A[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(majorityElement(A));
    }
}
