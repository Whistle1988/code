package test;

public class XOR {
    public void xor(int []a,int []b){
        int []sum = new int[a.length*a.length];
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                sum[x++] = a[i]+b[j];
            }
        }
        //System.out.println(sum);
        x = sum[0]^sum[1];
        for (int i = 2; i < sum.length; i++) {
            x ^= sum[i];
        }
        System.out.println(x);
    }
}
