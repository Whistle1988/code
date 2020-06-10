package bag;

/**
 * @author YoSaukit
 * @date 2020/2/4 18:11
 */
public class No74_Search2DMatrix {
    public static void main(String[] args) {
        No74_Search2DMatrix search2DMatrix = new No74_Search2DMatrix();
        int[][] matrix = {
                {1}
        };
        int target = 23;
        System.out.println(search2DMatrix.searchMatrix(matrix,target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0)return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target<matrix[0][0]||target>matrix[m-1][n-1])return false;
        int i=0;
        while(i<m){
            if (matrix[i][0]<=target&&target<=matrix[i][n-1]){
                return binary(matrix[i],target,0,n-1);
            }else{
                i++;
            }
        }
        return false;
    }
    boolean binary(int[] line,int target,int start,int end){
        if (start>end)return false;
        int mid = start + (end - start)/2;
        if (line[mid] == target)return true;
        else if (line[mid]<target){
            return binary(line,target,mid+1,end);
        }else
            return binary(line,target,start,mid-1);
    }

}
