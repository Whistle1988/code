package targetOffer.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/13 19:25
 */
public class Test1 {
    public static String reverse(int k, String s) {
        int n = s.length();
        if (k >= n) {
            return reverseWords(s);
        }
        List<String> list = new ArrayList<>();
        int tmp = 1;
        int group = n / k;
        int remain = n % k;
        for (int i = 0; i < n; i++) {
            if ((i + 1) % k == 0) {
                tmp = (i + 1) / k;
                String sub = s.substring((tmp - 1) * k, tmp * k );
                String s1 = reverseWords(sub);
                list.add(s1);
            }
            if (i >= group * k) {
                String sub = s.substring(i);
                String s1 = reverseWords(sub);
                list.add(s1);
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();

    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        String str = in.nextLine();
        System.out.println(reverse(Integer.parseInt(n), str));
    }
}
