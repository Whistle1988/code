package targetOffer.netease;

import java.util.*;

/**
 * @author qiuxiujie
 * @date 2020/9/12 15:01
 */
public class Test1 {
    static int result = 0;

    public static int find(Map<Integer, List<Integer>> map, int k, List<Integer> node) {
        if (k > node.size() - 1) {
            return result;
        }
        int key = node.get(k);
        if (map.get(key).size() < 2) {
            return find(map, ++k, node);
        }
        int left = map.get(key).get(0);
        int right = map.get(key).get(1);
        if (left != -1) {
            if (!map.containsKey(left) && !map.containsKey(right)) {
                result++;
            }
        }
        return find(map, ++k, node);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> node = new ArrayList<>();
        while (n > 0) {
            String line = in.nextLine();
            if (line.equals("")) continue;
            String[] strings = line.split(" ");
            int k = Integer.parseInt(strings[0]);
            String child = strings[1];
            int v = Integer.parseInt(strings[2]);
            if (!node.contains(k)) {
                node.add(k);
            }
            if (child.equals("left")) {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                map.put(k, list);
            } else {
                if (map.containsKey(k)) {
                    List<Integer> list = map.get(k);
                    list.add(v);
                    map.put(k, list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(-1);
                    list.add(v);
                    map.put(k, list);
                }
            }
            n--;
        }
        Collections.sort(node);
        find(map, 0, node);
        System.out.println(result);

    }
}
