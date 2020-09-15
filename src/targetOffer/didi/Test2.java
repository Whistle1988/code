package targetOffer.didi;

import java.util.*;

/**
 * @author qiuxiujie
 * @date 2020/9/13 19:52
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            List<List<Integer>> rList = new ArrayList<>();
            int tmp = 0;
            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                if (c <= k) {
                    List<Integer> list ;
                    if (!map.containsKey(a)){
                        list = new ArrayList<>();
                    }else{
                        list = map.get(a);
                    }
                    list.add(b);
//                    map.put(a,list);
                    list.add(a);
                    rList.add(list);
                }
            }
            System.out.println(judge(n, rList));
            T--;
        }
    }

    private static String judge(int n, List<List<Integer>> list) {
        if (list.size() == 0) {
            return "No";
        }
        Set<Integer> set = new HashSet<>(list.get(0));
        int round = 3;
        while (round > 0) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    if (set.remove(list.get(i).get(j))) {
                        set.addAll(list.get(i));
                        break;
                    }
                }
            }
            round--;
        }
        return set.size() == n ? "Yes" : "No";
    }
}
