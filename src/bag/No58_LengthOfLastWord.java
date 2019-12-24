package bag;

/**
 * @author YoSaukit
 * @date 2019/12/23 11:06
 */
public class No58_LengthOfLastWord {
    public static void main(String[] args) {
        No58_LengthOfLastWord lengthOfLastWord = new No58_LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("     "));
    }
    public int lengthOfLastWord(String s) {
        if (s.length()==0)return 0;
        String[] strs = s.split(" ");
        if (strs.length!=0) return strs[strs.length-1].length();
        else return 0;
    }
}
