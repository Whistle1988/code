package bag;

public class No8_strToInt {
    public static void main(String[] args) {
        No8_strToInt no8_strToInt = new No8_strToInt();
        System.out.println(no8_strToInt.myAtoi("   +012"));
    }

    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;
       str = str.trim();
       if (str.equals("")){
           return 0;
       }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length()) {
            if (str.charAt(index) - '0' < 0 || str.charAt(index) - '9' > 0) break;
            if (result > (Integer.MAX_VALUE - (str.charAt(index) - '0')) / 10)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }
        return result * sign;

    }
}
