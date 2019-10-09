package bag;

/**
 * @author YoSaukit
 * @date 2019/10/9 19:30
 */
public class No9_PalindromeNumber {
    public static void main(String[] args) {
        No9_PalindromeNumber no9_palindromeNumber = new No9_PalindromeNumber();
        System.out.println(no9_palindromeNumber.isPalindrome(101));
    }
    public boolean isPalindrome(int x) {
        if (x<0)return false;
        String str = Integer.toString(x);
        int i=0,j=str.length()-1;
        if (str.charAt(0)=='+')i=1;
        while(i<j&&str.charAt(i)==str.charAt(j)){
            i++;
            j--;
        }
        if (j<=i)return true;
        return false;
    }
}
