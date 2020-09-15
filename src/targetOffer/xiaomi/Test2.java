package targetOffer.xiaomi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author qiuxiujie
 * @date 2020/9/15 19:34
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
