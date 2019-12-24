package bag;

import java.util.Arrays;

/**
 * @author YoSaukit
 * @date 2019/12/23 11:18
 */
public class No59_SpiralMatrixII {
    public static void main(String[] args) {
        No59_SpiralMatrixII spiralMatrixII = new No59_SpiralMatrixII();
        System.out.println(Arrays.deepToString(spiralMatrixII.generateMatrix(0)));
    }
    public int[][] generateMatrix(int n) {
        return matrix(new int[n][n],0,n,1);
    }
    public int[][] matrix(int[][] res, int s,int e,int a){
        if (s>=e)return res;
        for (int i = s; i < e; i++){
            res[s][i] = a++;
            if (i==e-1){
                for (int j = s+1; j < e; j++) {
                    res[j][e-1] = a++;
                    if (j==e-1){
                        for (int k = e-2; k >=s ; k--) {
                            res[e-1][k] = a++;
                            if (k == s) {
                                for (int l = e-2; l >= s+1 ; l--) {
                                    res[l][s] = a++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return matrix(res,s+1,e-1,a);
    }
}
