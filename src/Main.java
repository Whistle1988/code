import Strings.ReverseInteger;
import test.Mask;
import test.StaffAver;
import test.XOR;
import test.while123;

class Solution {
    public int myAtoi(String str) {
        int result = 0;
        if (str == null || str.length() == 0) return result;
        str = str.trim();
        if (str.length() == 0) return 0;
        char firstChar = str.charAt(0);
        if (firstChar != '+' && firstChar != '-' && !Character.isDigit(firstChar)) {
            return result;
        }
        boolean isNegative = false;
        if (firstChar == '+' || firstChar == '-') {
            str = str.substring(1);
            if (firstChar == '-') isNegative = true;
        }
        int index = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int temp = result * 10 + Integer.parseInt(String.valueOf(str.charAt(index)));
            if (temp / 10 != result) {
                //check if overflow
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = temp;
            index++;
        }
        if (isNegative) {
            result = -result;
        }
        return result;
    }

}

public class Main {
    public static void main(String[] args) {

//        ReverseInteger reverseInteger = new ReverseInteger();
//        System.out.println(reverseInteger.reverse(1534236469));
//        System.out.println(reverseInteger.reverse(-1));
//
//        StaffAver staffAver = new StaffAver();
//        int []arr = {1};
//        staffAver.aver(arr);

//        XOR xor = new XOR();
//        int []a={1,2,1,0,0};
//        int []b={1,2,3,0,0};
//        xor.xor(a,b);
//        while123 while123 = new while123();
//        while123.getValueA();
        Mask mask = new Mask();
        mask.str("chuangpu@whitehouse.com");
    }


}
