package targetOffer;

/**
 * @author YoSaukit
 * @date 2020/4/8 16:39
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int start = 0, max = 0;
        if (s == null) return 0;
        if (s.length() == 1) return s.length();
        for (int i = 1; i < s.length(); i++) {
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    start = j + 1;
                }
            }
            if (i - start + 1 > max) max = i - start + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
