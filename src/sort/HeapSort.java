package sort;

/**
 * 堆排序
 * 两个过程：建立堆；堆顶与堆的最后一个元素交换位置
 * 从最后一个非叶子节点开始，对于整棵树进行大根堆的调整
 * 自下而上，自右向左
 *
 * @author YoSaukit
 * @date 2020/3/24 21:01
 */
public class HeapSort {
    public void heapSort(int[] A) {
        for (int i = A.length / 2 - 1; i >= 0; i--) {
            adjustHeap(A, i, A.length);
        }
        for (int i = A.length - 1; i > 0; i--) {
            swap(A, 0, i);
            adjustHeap(A, 0, i);
        }
    }

    public void adjustHeap(int[] A, int i, int length) {
        int temp = A[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //让k先指向子节点中最大的节点
            if (k + 1 < length && A[k] < A[k + 1])
                k++;
            //子节点更大，进行值的交换
            if (A[k] > temp) {
                swap(A, i, k);
                i = k;
            } else
                break;
        }
    }

    public void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }


}
