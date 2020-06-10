package bag;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YoSaukit
 * @date 2020/3/19 15:21
 */
public class No409 {
    public static void main(String[] args) {
        No409 no409 = new No409();
        System.out.println(no409.longestPalindrome("ccc"));
    }

    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int flag = 0;
        for (Integer v :
                map.values()) {
            if (v % 2 == 0) res += v;
            else if (v != 1) {
                res += v - 1;
                flag = 1;
            } else flag = 1;
        }
        return res+flag;
    }
}
