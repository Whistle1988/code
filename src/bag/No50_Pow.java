package bag;

/**
 * @author YoSaukit
 * @date 2019/12/16 10:49
 */
public class No50_Pow {
    public static void main(String[] args) {
        No50_Pow pow = new No50_Pow();
        System.out.println(pow.myPow(2.1, -3));
    }

    public double myPow(double x, int n) {
        double pow = myPowHelper(x, n);
        return n < 0 ? 1 / pow : pow;
    }

    public double myPowHelper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double tmp = myPowHelper(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        }
        return tmp * tmp * x;
    }
}
