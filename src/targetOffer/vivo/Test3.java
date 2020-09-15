package targetOffer.vivo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/12 20:40
 */
public class Test3 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr) {
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strs = str.split(",");
        int n = strs.length;
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = i;
            if (strs[i].equals("-1")){
                A[i][1] = 0;
            }else{
                A[i][1] = Integer.parseInt(strs[i]);
            }
        }
        System.out.println(Arrays.deepToString(A));
        int[] result = findOrder(n, A);
        StringBuilder sb = new StringBuilder();
        sb.append(result[0]);
        for (int i = 1; i < n; i++) {
            sb.append(",");
            sb.append(result[i]);
        }
        System.out.println(sb.toString());

    }
}
