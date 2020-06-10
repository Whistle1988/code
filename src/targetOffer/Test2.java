package targetOffer;

import java.util.Scanner;

/**
 * @author YoSaukit
 * @date 2020/4/8 20:00
 */
public class Test2 {
    public static int check(String str,int k){
        String[] s = str.split("[+|-]");
        String sign = str.replaceAll("\\d*","");
        int sum = Integer.parseInt(s[0]);
        for (int i = 0; i < s.length - 1; i++) {
            switch (sign.charAt(i)){
                case '+':
                    sum +=Integer.parseInt(s[i+1]);
                    break;
                case '-':
                    sum -= Integer.parseInt(s[i+1]);
                    break;
            }
        }
        if (sum == k)return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            String s = strs[0];
            int result = 0;
            char[] c = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            int k = Integer.parseInt(strs[1]);
            int len = str.length()-1;
            int[] sign = new int[len];
            while(sign[0]<3){
                sb.append(c[0]);
                for (int j = 0; j < len; j++) {
                    if (sign[j] == 1){
                        sb.append("+");
                    }else if (sign[j]==2){
                        sb.append("-");
                    }
                    sb.append(c[i+1]);
                }
            }
            result += check(sb.toString(),k);
            sb.setLength(0);
            sign[len-1]++;
            for (int j = len-1; j >0 ; j--) {
                if (sign[i] == 3){
                    sign[i] = 0;
                    sign[i-1]++;
                }
            }
            System.out.println(result);
        }
    }
}
