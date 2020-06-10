package bag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2020/2/25 16:46
 */
public class No77_Combinations {
    public static void main(String[] args) {
        No77_Combinations combinations = new No77_Combinations();
        Iterator i = combinations.combine(4,2).iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs,new ArrayList<>(),1,n,k);
        return combs;

    }
    public void combine(List<List<Integer>> combs,List<Integer> comb,int start,int n,int k){
        if (k == 0){
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n-k+1; i++) {
            comb.add(i);
            combine(combs,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
