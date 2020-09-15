package targetOffer.vivo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 20:24
 */
public class Test2 {
    static int del = 0;

    public static boolean validPalindrome(String s) {
        int L = 0, R = s.length() - 1;
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) {
                if (isPalindrome(s, L + 1, R)) {
                    del = L;
                } else if (isPalindrome(s, L, R - 1)) {
                    del = R;
                }
                return isPalindrome(s, L + 1, R) || isPalindrome(s, L, R - 1);
            } else {
                L++;
                R--;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int L, int R) {
        while (L < R) {
            if (s.charAt(L++) != s.charAt(R--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (!validPalindrome(str)) {
            System.out.println("false");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i != del) {
                    sb.append(str.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
