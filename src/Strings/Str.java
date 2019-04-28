package Strings;

public class Str {
    public int strStr(String haystack, String needle) {

        if (needle == null) {
            return 0;
        }
        int i=0,j=0;
        while (i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i)!=needle.charAt(j)){
                i=i-j+1;
                j=0;
            }else{
                i++;
                j++;
            }
        }
        if(j==needle.length()){
            return i-needle.length();
        }
        return -1;
    }
}
