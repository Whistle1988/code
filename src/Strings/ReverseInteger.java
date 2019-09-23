package Strings;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = x * (-1);
        }

        String str = String.valueOf(x);
        int temp = 0;
        int len = str.length();
        if (len == 1) {
            return (str.charAt(len - 0 - 1) - '0') * flag;
        }
        temp = str.charAt(len - 0 - 1) - '0';
        for (int i = 1; i < len; i++) {
            result = temp * 10 + (str.charAt(len - i - 1) - '0');
            if (result / 10 != temp) return 0;
            temp = result;
        }

        return result * flag;
    }
}
