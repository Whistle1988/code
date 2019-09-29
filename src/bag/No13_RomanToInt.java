package bag;

/**
 * @author YoSaukit
 * @date 2019/9/29 16:52
 */
public class No13_RomanToInt {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int nums[] = new int[ch.length];
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[nums.length - 1];
    }
}
