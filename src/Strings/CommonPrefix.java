package Strings;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = "";
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        int index = 0;
        for (int i = 0; i < min; i++) {
            char ch = strs[index].charAt(i);//需要判空处理
            for (int j = 1; j < strs.length; j++) {

                if (strs[j].charAt(i) != ch) {
                    return str;
                }
            }
            str += strs[index].substring(i, i + 1);
        }

        return str;
    }
}
