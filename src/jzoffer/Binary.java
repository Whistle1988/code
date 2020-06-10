package jzoffer;

/**
 * 二进制
 *
 * @author YoSaukit
 * @date 2020/5/23 21:00
 */
public class Binary {
    /**
     * 二进制中1的个数
     * 1. 无符号右移>>>
     * 2. n&(n-1)：把n最右边的1变成0
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
        int count = 0;
        while (n != 0) {
            count += n&1;
            n>>>=1;
        }
        return count;
    }
}
