package sort;

/**
 * @author YoSaukit
 * @date 2020/3/24 20:57
 */
public class ShellSort {
    public void shellSort(int[] A) {
        int gap = A.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int j = 0; j + gap < A.length; j++) {
                for (int k = 0; k + gap < A.length; k += gap) {
                    if (A[k] > A[k + gap]) {
                        int temp = A[k + gap];
                        A[k + gap] = A[k];
                        A[k] = temp;
                    }
                }
            }
        }
    }
}
