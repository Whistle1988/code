package bag;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author YoSaukit
 * @date 2020/4/15 23:19
 */
public class No542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0],y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x+dx[i];
                int newY = y+dy[i];
                if (newX>=0&&newX<m&&newY>=0&&newY<n&&matrix[newX][newY] == -1){
                    matrix[newX][newY] = matrix[x][y]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }

        }
        return matrix;
    }
}
