package bag;

import java.util.LinkedList;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/12/23 16:02
 */
public class No60_PermutationSequence {
    public static void main(String[] args) {
        No60_PermutationSequence sequence = new No60_PermutationSequence();
        sequence.getPermutation(4,9);
    }

    public String getPermutation(int n, int k) {
        List<Integer> num = new LinkedList<>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i*fact[i-1];
        }
        k = k-1;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int ind = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(num.get(ind));
            num.remove(ind);
        }
        return sb.toString();
    }
}
