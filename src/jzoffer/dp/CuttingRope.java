package jzoffer.dp;

/**
 * @author YoSaukit
 * @date 2020/5/19 21:22
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }

    public int cuttingRope2(int n) {
        if(n<=3) return n-1;
        long sum = 1;
        while (n > 4) {
            sum = (sum * 3) % 1000000007;
            n -= 3;
        }
        return (int)(sum * n % 1000000007);
    }
}
