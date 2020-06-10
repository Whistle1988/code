package targetOffer;

import java.util.*;

/**
 * @author YoSaukit
 * @date 2020/4/15 19:59
 */
public class stack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashMap<Integer,Integer> cost = new HashMap<>();
        HashMap<Integer,List> map = new HashMap<>();
        String[] strs = str.split(" ");
        int n = Integer.parseInt(strs[0]);
        int[] group = new int[n];
        for (int i = 1; i < strs.length; i++) {
            group[i-1] = Integer.parseInt(strs[i]);
        }
        //n个组
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] g = s.split(" ");
            if (g.length<2) {
                System.out.println("NA");
                return;
            }
            cost.put(Integer.parseInt(g[0]),Integer.parseInt(g[1]));
            if (group[Integer.parseInt(g[0])]==0){
                map.put(Integer.parseInt(g[0]),null);
                break;
            }
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < group[Integer.parseInt(g[0])]; j++) {
                tmp.add(Integer.parseInt(g[j+2]));
            }
            map.put(Integer.parseInt(g[0]),tmp);
        }
        List gList = map.get(1);
        int[] indice = new int[n];
        for (int i = 0; i < n; i++) {
            indice[i] = 0;
        }
        HashMap<Integer,List> lian = new HashMap<>();
        for (int i = 0; i < gList.size(); i++) {

        }
    }
}
