package jzoffer;

/**
 * @author YoSaukit
 * @date 2020/5/23 23:13
 */
public class Normal {
    /**
     * 二维数组中的查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1,j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j]>target)i--;
            else if (matrix[i][j]<target)j++;
            else return true;
        }
        return false;
    }
















}
