package bag;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author YoSaukit
 * @date 2020/4/16 17:38
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[][] merge = new int[intervals.length][2];
        int index = -1;
        for (int[] intvl : intervals) {
            if (index == -1 || intvl[0] > merge[index][1]) {
                merge[++index] = intvl;
            } else {
                merge[index][0] = Math.max(merge[index][0], intvl[0]);
            }
        }
        return Arrays.copyOf(merge,index+1);
    }
    public int[][] _merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
