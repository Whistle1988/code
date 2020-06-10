package bag;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Sliding window
 * @author YoSaukit
 * @date 2020/2/12 15:47
 */
public class No76_MiniWindowSubstring {
    public static void main(String[] args) {
//        No76_MiniWindowSubstring substring = new No76_MiniWindowSubstring();
        String a = ",a,,b,";
        System.out.println(Arrays.toString(a.split(",")));
//        System.out.println(substring.minWindow("ABCDDEDD", "AC"));
    }

    public String minWindow(String s, String t) {
        //用set没有考虑到t里重复字符，所以换成用数组记录每个字符个数
//        Set<Character> set = new HashSet<>();
//        String res = "";
//        int len = t.length();
//        int mini = Integer.MAX_VALUE;
//        int start = 0, end = len-1;
//        while (end < s.length()) {
//            for (int i = start; i <= end; i++) {
//                if (t.contains(s.substring(i,i+1))){
//                    set.add(s.charAt(i));
//                    if (set.size() == len) {
//                        if (end-start+1<mini){
//                            mini = end-start+1;
//                            res = s.substring(start,end+1);
//                        }
//                        mini = end-start+1>mini?mini:end-start+1;
//                        set.clear();
//                        start = start+1;
//                        end = start+2;
//                        break;
//                    }
//                }
//            }
//            end++;
//        }
//        return res;
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();
        int[] map = new int[256];
        int end = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < t_array.length; i++) {
            map[t_array[i]]++;
        }
        int count = t_array.length;
        int min_start = 0;
        while (end < s_array.length) {
            if (map[s_array[end]] > 0) {
                count--;
            }
            map[s_array[end]]--;
            while (count == 0) {
                if ((end - start + 1) < min) {
                    min = end - start + 1;
                    min_start = start;
                }
                map[s_array[start]]++;
                if (map[s_array[start]] > 0) {
                    count++;
                }
                start++;
            }
            end++;
        }
        if (min_start + min > s_array.length) return "";
        return s.substring(min_start, min + min_start);
    }
}
