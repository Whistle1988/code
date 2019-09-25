package bag;


/**
 * @author YoSaukit
 * @date 2019/9/25 10:28
 */
public class No65_ValidNumber {
    public static void main(String[] args) {
        No65_ValidNumber no65_validNumber = new No65_ValidNumber();
        System.out.println(no65_validNumber.isNumber("0"));
    }

    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return false;
        }
        boolean hasE, hasFirst, hasDot, hasDigit;
        hasE = hasFirst = hasDot = hasDigit = false;
        char c;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                hasFirst = hasDigit = true;
                continue;
            }
            switch (c) {
                case 'e':
                    if (hasE || !hasDigit)
                        return false;
                    hasE = true;
                    hasFirst = hasDigit = false;
                    hasDot = true;
                    continue;
                case '+':
                case '-':
                    if (hasFirst)
                        return false;
                    hasFirst = true;
                    continue;
                case '.':
                    if (hasDot)
                        return false;
                    hasFirst = hasDot = true;
                    hasDigit = false;
                    continue;
                default:
                    return false;
            }
        }
        return hasDigit;
    }


}
