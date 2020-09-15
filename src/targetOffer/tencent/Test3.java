package targetOffer.tencent;

import java.util.*;

/**
 * @author qiuxiujie
 * @date 2020/9/6 21:26
 */
public class Test3 {
    private static LinkedList<Freq> topString(List<String> allStr, int maxK) {
        //统计频次
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : allStr) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        //维护当前看到的前k个出现频次最高的元素
        PriorityQueue<Freq> max = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return a.getCount() - b.getCount();
            }
        });
        //维护当前看到的前k个出现频次最高的元素
        PriorityQueue<Freq> min = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq a, Freq b) {
                return b.getCount() - a.getCount();
            }
        });
        for (String key : map.keySet()) {
            if (max.size() < maxK) {
                max.add(new Freq(key, map.get(key)));
            } else if (map.get(key) > max.peek().getCount()) {
                max.remove();
                max.add(new Freq(key, map.get(key)));
            }

            if (min.size() < maxK) {
                min.add(new Freq(key, map.get(key)));
            } else if (map.get(key) < min.peek().getCount()) {
                min.remove();
                min.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Freq> res = new LinkedList<>();

        Freq[] array = new Freq[max.size()];
        max.toArray(array);
        Arrays.sort(array, new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o2.getValue().compareTo(o1.value);
            }
        });
        for(int i=0;i<array.length;i++){
            res.add((Freq)array[array.length-1-i]);
        }
        min.toArray(array);
        Arrays.sort(array, new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o2.getValue().compareTo(o1.value);
            }
        });
        for(int i=0;i<array.length;i++){
            res.add((Freq)array[array.length-1-i]);
        }
        return res;
    }

    private static class Freq {
        String value;
        int count;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Freq(String value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = in.next();
            list.add(str);
        }
        LinkedList<Freq> result = topString(list,K);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i).value);
            System.out.print(" ");
            System.out.println(result.get(i).count);
        }

    }
}
