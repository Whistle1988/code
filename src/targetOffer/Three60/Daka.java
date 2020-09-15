package targetOffer.Three60;

import java.util.*;

/**
 * @author qiuxiujie
 * @date 2020/9/11 20:42
 */
public class Daka {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<Integer> inWork = new ArrayList<>();
        List<Integer> outWork = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        while (m > 0) {
            int id = in.nextInt();
            int flag = in.nextInt();
            if (flag == 1) {
                inWork.add(id);
            } else {
                outWork.add(id);
            }
            m--;
        }
        List<Integer> except = new ArrayList<>();
        int i = 0, j = outWork.size() - 1;
        while (i < inWork.size() && j >= 0) {
            int a = inWork.get(i), b = outWork.get(j);
            if (a == b) {
                resList.add(a);
            } else {
                except.add(a);
                except.add(b);
            }
            i++;
            j--;
        }
        Collections.sort(except);
        int index = 1;
        if (except.size() < n) {
            for (int k = 0; k < except.size(); index++) {
                if (index != except.get(k)) {
                    resList.add(index);
                } else {
                    k++;
                }
            }
            while (index < n + 1) {
                resList.add(index++);
            }
        }
        int tmp = resList.get(0);
        System.out.print(tmp);
        System.out.print(" ");
        for (int k = 1; k < resList.size(); k++) {
            if (tmp == resList.get(k)) {
                tmp = resList.get(k);
                continue;
            }
            System.out.print(resList.get(k));
            System.out.print(" ");
        }

    }
}
