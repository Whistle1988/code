package bag;

import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2019/9/29 15:56
 */
public class No12_IntToRoman {
    public static void main(String[] args) {
        No12_IntToRoman no12_intToRoman = new No12_IntToRoman();
        System.out.println(no12_intToRoman.intToRoman(11));
    }
    public String intToRoman(int n) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
    }

}
