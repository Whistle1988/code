package bag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author YoSaukit
 * @date 2019/9/30 17:00
 */
public class No3_longestSubStr {
    public static void main(String[] args) {
        No3_longestSubStr no3_longestSubStr = new No3_longestSubStr();
        System.out.println(no3_longestSubStr.lengthOfLongestSubstring("adav"));
    }

    //    public int lengthOfLongestSubstring(String s) {
//        String str = "";
//        int index=0,count=0,max=1;
//        if (s==""||s==null||s.length()==0)return 0;
//        while (index < s.length()) {
//            if (str.contains(s.substring(index,index+1))){
//                if (s.charAt(index)==str.charAt(str.length()-1)){
//                    str = s.substring(index,index+1);
//                    count=str.length();
//                }else{
//                    for (int i = 0; i < str.length(); i++) {
//                        if (s.charAt(index)==str.charAt(i)&&i<str.length()){
//                            str = str.substring(i+1);
//                            str+=s.substring(index,index+1);
//                            count=str.length();
//                            break;
//                        }
//                    }
//                }
//            }else{
//                str+=s.substring(index,index+1);
//                count++;
//                max=max<count?count:max;
//            }
//            index++;
//        }
//        return max;
//    }
//    public int lengthOfLongestSubstring(String s) {
//        int i=0,j=0,max=0;
//        Set<Character> set = new HashSet<>();
//        while (j < s.length()) {
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                max = Math.max(max,set.size());
//            }else{
//                set.remove(s.charAt(i++));
//            }
//        }
//        return max;
//    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)return 0;
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j=0,max=0;
        while (j < s.length()) {
            if (!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
                max = Math.max(max,j-i+1);
            }else{
                i = Math.max(i,map.get(s.charAt(j))+1);
            }
            j++;
        }
        return max;
    }
}
