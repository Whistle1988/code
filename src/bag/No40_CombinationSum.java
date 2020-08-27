package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/11/5 22:18
 */
public class No40_CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        No40_CombinationSum combinationSum = new No40_CombinationSum();
        String str = combinationSum.combinationSum2(candidates, target).toString();
        System.out.println(str);
    }

    public List<List<Integer>> combinationSum2(int[] prices, int m) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(prices);
        getResult2(result, new ArrayList<>(), prices, m, 0);
        return result;
    }

    public void getResult2(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                getResult2(result, cur, candidates, target - candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
    }
}
