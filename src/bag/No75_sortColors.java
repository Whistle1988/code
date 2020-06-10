package bag;

/**
 * @author YoSaukit
 * @date 2020/2/9 22:04
 */
public class No75_sortColors {
    public static void main(String[] args) {
        No75_sortColors sortColors = new No75_sortColors();
        int[] A = {2,0,2,1,1,0};
        int n = A.length;
        sortColors.sortColors(A,n);
    }
    public void sortColors(int[] A,int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }
}
