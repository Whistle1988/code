package targetOffer.tencent;

import java.util.*;

/**
 * @author qiuxiujie
 * @date 2020/9/6 20:22
 */
public class Test2 {
    public static int heard(List<List<Integer>> list, int start) {
        Set<Integer> set = new HashSet<>(list.get(start));
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
        return set.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int group = in.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        int start = -1;
        while (group > 0) {
            int a = in.nextInt();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                int x = in.nextInt();
                if (x == 0) {
                    start = list.size();
                }
                tmp.add(x);
            }
            list.add(tmp);
            group--;
        }
        if (start == -1) {
            System.out.println(0);
        }
        int result = Math.min(heard(list, start), total);
        System.out.println(result);
    }
}
