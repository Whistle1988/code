package bag;

public class No28_ImplementStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle  = "lo";
        No28_ImplementStr no28_implementStr = new No28_ImplementStr();
        System.out.println(no28_implementStr.strStr(haystack,needle));
    }
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle))return -1;
        int k1=0,k2=0;
        int first = 0;
        while (k1 < haystack.length() && k2 < needle.length()) {
            if(haystack.charAt(k1)==needle.charAt(k2)){
                k1++;
                k2++;
            }else{
                first++;
                k1=first;
                k2=0;
            }
        }
        if(k2==needle.length()){
            return first;
        }else return -1;
    }
}
