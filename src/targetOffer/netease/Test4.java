package targetOffer.netease;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 16:32
 */
public class Test4 {
    static int result = 0;

    public static int maxDating(Map<Integer, Boolean> B, Map<Integer, Boolean> G, int[][] date) {
        int count = 5;
        while (count > 0) {
            for (int i = 0; i < date.length; i++) {
                int boy = date[i][0], girl = date[i][1];
                if (B.containsKey(boy) && !B.get(boy) && G.containsKey(girl) && !G.get(girl)) {
                    B.put(boy, true);
                    G.put(girl, true);
                    result++;
                } else if (G.get(girl)){
                    for (int j = 0; j < date.length; j++) {
                        if (date[i][1] == girl) {
                            B.put(date[i][0], false);
                            G.put(date[i][1], false);
                        }
                    }
                    result--;
                }
            }
            count--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String boy = in.nextLine();
        String[] boys = boy.split(" ");
        Map<Integer, Boolean> B = new HashMap<>();
        for (int i = 0; i < boys.length; i++) {
            B.put(Integer.parseInt(boys[i]), false);
        }
        String girl = in.nextLine();
        String[] girls = girl.split(" ");
        Map<Integer, Boolean> G = new HashMap<>();
        for (int i = 0; i < girls.length; i++) {
            G.put(Integer.parseInt(girls[i]), false);
        }
        int n = Integer.parseInt(in.next());
        int[][] date = new int[n][n];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            date[i][0] = a;
            date[i][1] = b;
        }
        maxDating(B, G, date);
        System.out.println(result);

    }

}
