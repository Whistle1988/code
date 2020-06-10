package sort;

/**
 * 选择排序，最稳定的算法之一，O(n^2)每次在未排序序列中找到最小（大）元素，存放在排序序列的起始位置
 * @author YoSaukit
 * @date 2020/3/24 20:02
 */
public class SelectionSort {
    public int[] selectionSort(int[] A){
        if (A.length == 0)return A;
        for (int i = 0; i < A.length; i++) {
            int midIndex = i;
            for (int j = i; j < A.length; j++) {
                if (A[j]<A[midIndex])
                    midIndex = j;
            }
            int temp = A[midIndex];
            A[midIndex] = A[i];
            A[i] = temp;
        }
        return A;
    }

}
