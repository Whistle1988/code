package sort;

/**
 * 冒泡排序
 * 最佳O(n) 最差O(n^2)
 * ref:https://www.cnblogs.com/guoyaohua/p/8600214.html
 * @author YoSaukit
 * @date 2020/3/24 19:01
 */

public class BubbleSort {
    public int[] bubbleSort(int[] A) {
        if (A.length == 0) {
            return A;
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - 1 - i; j++) {
                if (A[j]>A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }

            }
        }
        return A;
    }
}
