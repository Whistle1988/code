package bag;

import java.lang.reflect.Array;
import java.util.*;

import static java.util.Arrays.asList;

public class No56_MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{0,4}};
        No56_MergeIntervals no56_mergeIntervals = new No56_MergeIntervals();
        int[][] arr = no56_mergeIntervals.merge(intervals);
        System.out.println(Arrays.deepToString(arr));

    }

    //    public int[][] merge(int[][] intervals) {
//        if (intervals == null || intervals.length == 0) return new int[][] {};
//        LinkedList<int[]> q = new LinkedList<>();
//        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
//        q.offer(intervals[0]);
//
//        for (int i = 1; i < intervals.length; i++) {
//            if (q.peekLast()[1] >= intervals[i][0])
//                q.peekLast()[1] = Math.max(q.peekLast()[1], intervals[i][1]);
//            else q.offer(intervals[i]);
//        }
//
//        return q.toArray(new int[q.size()][]);
//    }
//    public int[][] merge(int[][] intervals) {
//       if (intervals == null||intervals.length==0)
//           return new int[0][0];
//        Arrays.sort(intervals,(Comparator.comparingInt(x -> x[0])));
//        ListSet<int[]> merged = new ArrayList<>();
//        int[] current = intervals[0];
//        for (int i = 1; i < intervals.length; i++) {
//            if (current[1]>=intervals[i][0])
//                current[1] = Math.max(current[1],intervals[i][1]);
//            else{
//                merged.add(current);
//                current = intervals[i];
//            }
//        }
//        merged.add(current);
//        return merged.toArray(new int[0][0]);
//    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null||intervals.length==0){
            return new int[0][0];
        }
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals,(Comparator.comparingInt(x -> x[0])));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1]>=intervals[i][0]){
                current[1] = Math.max(current[1],intervals[i][1]);
            }else{
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][0]);
    }

}
