package targetOffer.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 15:52
 */
public class Test2 {
    public static int find(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int status = 0;
        map.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == 'a') {
                status = status ^ (1 << 0);
                map.putIfAbsent(status, i);
            } else if (now == 'b') {
                status = status ^ (1 << 1);
                map.putIfAbsent(status, i);
            } else if (now == 'c') {
                status = status ^ (1 << 2);
                map.putIfAbsent(status, i);
            } else if (now == 'x') {
                status = status ^ (1 << 3);
                map.putIfAbsent(status, i);
            } else if (now == 'y') {
                status = status ^ (1 << 4);
                map.putIfAbsent(status, i);
            } else if (now == 'z') {
                status = status ^ (1 << 5);
                map.putIfAbsent(status, i);
            }
            if (map.containsKey(status)) {
                max = Math.max(max, i - map.get(status));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(find(s));

    }
}
