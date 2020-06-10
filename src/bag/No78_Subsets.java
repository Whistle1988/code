package bag;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YoSaukit
 * @date 2019/10/28 21:54
 */
public class No78_Subsets {
    public static void main(String[] args) {
        No78_Subsets no78_subsets = new No78_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> result = no78_subsets.subsets(nums);
        result.forEach(list -> System.out.println(list.toString()));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int n : nums) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                List<Integer> numList = new ArrayList<>(list.get(i));
                numList.add(n);
                list.add(numList);
            }
        }
        return list;
    }
    public int myAtoi(String str) {
        str = str.trim();
        int flag=0;
        if (str.charAt(0)!='-'||str.charAt(0)!='+'||str.charAt(0)-'0'<10)return 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)-'0'<10){
                res = i==0?res:res*10;
                res+=str.charAt(i)-'0';
            }else
                break;
        }
        return res;
    }
}
