package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/9/26 11:37
 */
public class No73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        No73_SetMatrixZeroes no73_setMatrixZeroes = new No73_SetMatrixZeroes();
        no73_setMatrixZeroes.setZeroes(matrix);
    }
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix.length==0)return;
        List<Integer> rList = new ArrayList<>();
        List<Integer> cList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rList.add(i);
                    cList.add(j);
                }
            }
        }
        setRC(matrix,rList,cList);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void setRC(int [][]matrix,List<Integer> rList, List<Integer> cList){
        int r=0,c=0;
        while(r<rList.size()){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[rList.get(r)][i]=0;
            }
            r++;
        }
        while(c<cList.size()){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][cList.get(c)]=0;
            }
            c++;
        }
    }
}
