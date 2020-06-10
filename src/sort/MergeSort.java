package sort;

import java.util.Arrays;

/**
 * @author YoSaukit
 * @date 2020/3/24 21:46
 */
public class MergeSort {
    public int[] mergeSort(int[] A){
        if (A.length<=1)return A;
        int num = A.length >> 1;
        int[] leftA = Arrays.copyOfRange(A,0,num);
        int[] rightA = Arrays.copyOfRange(A,num,A.length);
        return mergeTwoArray(mergeSort(leftA),mergeSort(rightA));
    }
    public int[] mergeTwoArray(int[] A1,int[] A2){
        int i=0,j=0,k=0;
        int[] result = new int[A1.length+A2.length];
        while(i<A1.length&&j<A2.length){
            if (A1[i]<=A2[j]){
                result[k++] = A1[i++];
            }else{
                result[k++] = A2[j++];
            }
        }
        while (i < A1.length) {
            result[k++] = A1[i++];
        }
        while (i < A2.length) {
            result[k++] = A2[i++];
        }
        return result;
    }
}
