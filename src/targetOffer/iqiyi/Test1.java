package targetOffer.iqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/13 15:30
 */
public class Test1 {
    public static int lengthOfLongestSubstring(String s) {
        //滑动窗口核心点：1. 右指针右移 2.根据题意收缩窗口 3. 左指针右移更新窗口 4.根据题意计算结果
        if (s.length() == 0) return 0;
        Map<Character, Integer> win = new HashMap<>();
        int left = 0, right = 0, max = Integer.MIN_VALUE;
        while (right < s.length()) {
            if (win.containsKey(s.charAt(right))) {
                max = Math.max(max,right-left);
                int tmp = win.get(s.charAt(right));
                for (int i = left; i <= tmp; i++) {
                    win.remove(s.charAt(i));
                }
                left = tmp+1;
            }
            win.put(s.charAt(right),right);
            right++;
        }
        return Math.max(max,right-left);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
