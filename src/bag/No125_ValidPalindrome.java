package bag;

/**
 * @author YoSaukit
 * @date 2019/9/27 21:41
 */
public class No125_ValidPalindrome {
    public static void main(String[] args) {
        String s = "...,,aba";
        No125_ValidPalindrome no125_validPalindrome = new No125_ValidPalindrome();
        System.out.println(no125_validPalindrome.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s == "" || s.length() <= 1) return true;
        int start = 0, end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            while (start < s.length() && !('a' <= s.charAt(start) && s.charAt(start) <= 'z')
                    && !('0' <= s.charAt(start) && s.charAt(start) <= '9')) {
                start++;
            }
            while (end > 0 && !('a' <= s.charAt(end) && s.charAt(end) <= 'z')
                    && !('0' <= s.charAt(end) && s.charAt(end) <= '9')) {
                end--;
            }
            if (start >= s.length() || end <= 0) return true;
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
