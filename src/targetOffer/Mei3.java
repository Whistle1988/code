package targetOffer;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

/**
 * @author YoSaukit
 * @date 2020/4/16 20:00
 */
public class Mei3 {
    //    public static void backtrack(ListSet<ListSet<Integer>> res,ListSet<Integer> list,int[] nums){
//        if (list.size() == 2) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int num : nums) {
//            list.add(num);
//            backtrack(res,list,nums);
//            list.remove(list.size()-1);
//        }
//    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, k;
        n = cin.nextInt();
        k = cin.nextInt();
        int[] A = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            A[i] = cin.nextInt();
            if (map.containsKey(A[i])){
                map.replace(A[i],map.get(A[i])+1);
            }else
                map.put(A[i],1);
        }
        Arrays.sort(A);
        int x = k / n;
        k = k % n;
        int tmp = 0,index = 0;
        for (Integer key : map.keySet()) {
            if (tmp<x){
                tmp+=map.get(key);
            }else{
                index = key;
            }
        }
        tmp = 0;
        int index2 = 0;
        for (Integer key : map.keySet()) {
            if (tmp<k-1){
                tmp+=map.get(key);
            }else{
                index2 = key;
            }
        }
        System.out.println("(" + A[index] + "," + A[index2] + ")");
    }
}
