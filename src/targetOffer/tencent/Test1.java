package targetOffer.tencent;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/6 19:57
 */
public class Test1 {
    public static List<Integer> common(int n1, int[] A, int n2, int[] B) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (A[i] == B[j]) {
                result.add(A[i]);
            } else if (A[i] < B[j]) {
                j--;
            }else{
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] A = new int[n1];
        for (int i = 0; i < n1; i++) {
            A[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] B = new int[n2];
        for (int i = 0; i < n2; i++) {
            B[i] = in.nextInt();
        }
        List<Integer> result = common(n1,A,n2,B);
        StringBuilder sb = new StringBuilder();
        sb.append(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            sb.append(" ");
            sb.append(result.get(i));
        }
        System.out.println(sb.toString());

    }
}
