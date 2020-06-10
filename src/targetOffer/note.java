package targetOffer;

import java.util.*;

/**
 * @author YoSaukit
 * @date 2020/4/15 19:01
 */
public class note {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                if (j == 0){
                    if (ch[j]>'Z'||ch[j]<'A'){
                        System.out.println("error.0001");
                        return;
                    }
                }else{
                    if (ch[j]>'z'||ch[j]<'a'){
                        System.out.println("error.0001");
                        return;
                    }
                }
            }
            if (!map.containsKey(strs[i])){
                map.put(strs[i],1);
            }else{
                int tmp = map.get(strs[i]);
                map.remove(strs[i]);
                map.put(strs[i],tmp+1);
            }
        }
        int max = Integer.MIN_VALUE;
        List<String> list = new ArrayList<>();
        for (String i : map.keySet()) {
            if (map.get(i)>max)max = map.get(i);
        }
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            if (entry.getValue()==max){
                list.add(entry.getKey());
            }
        }
        if (list.size() == 1){
            System.out.println(list.get(0));
            return;
        }
        Collections.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println(list.get(0));
    }
}
