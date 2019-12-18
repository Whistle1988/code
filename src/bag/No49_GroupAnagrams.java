package bag;

import java.util.*;

/**
 * @author YoSaukit
 * @date 2019/12/15 20:38
 */
public class No49_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s :
                strs) {
            char[] ch =s.toCharArray();
            Arrays.sort(ch);
            String tmp = String.valueOf(ch);
            if (!map.containsKey(tmp))map.put(tmp,new ArrayList<>());
            map.get(tmp).add(s);
        }
        return new ArrayList<>(map.values());
    }


















}
