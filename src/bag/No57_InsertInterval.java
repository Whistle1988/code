package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/9/24 21:08
 */
public class No57_InsertInterval {
    public static void main(String[] args) {
        No57_InsertInterval no57_insertInterval = new No57_InsertInterval();
        int[][] intervals = {};
        int[] newInterval = {4,8};
        System.out.println(Arrays.deepToString(no57_insertInterval.insert(intervals,newInterval)));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        if (intervals==null||intervals.length==0){
            list.add(newInterval);
            return list.toArray(new int[0][0]);
        }

        int i=0;
        int n=intervals.length;
        while(i<n&&newInterval[0]>intervals[i][1]){
            list.add(intervals[i++]);
        }
        while(i<n&&intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i++]);
        }
        return list.toArray(new int[0][0]);

    }
}
