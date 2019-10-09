package bag;

/**
 * @author YoSaukit
 * @date 2019/10/8 19:52
 */
public class No5_Palindromic {
    private int lo,maxLen;
    public static void main(String[] args) {
        No5_Palindromic no5_palindromic = new No5_Palindromic();
        System.out.println(no5_palindromic.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len<2)return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalidrome(s,i,i);
            extendPalidrome(s,i,i+1);
        }
        return s.substring(lo,lo+maxLen);
    }
    private void extendPalidrome(String s, int j, int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        if (maxLen<k-j-1){
            lo = j+1;
            maxLen = k-j-1;
        }
    }
}
