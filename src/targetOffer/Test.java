package targetOffer;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author YoSaukit
 * @date 2020/4/8 19:21
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,5);
        map.put(3,8);
        map.put(4,7);
        map.put(6,9);
        map.put(5,2);
        map.put(8,3);
        map.put(7,4);
        map.put(9,6);
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            int len = str.length();
            if (str.length()%2!=0||str.length()==0){
                System.out.println("NO");
                continue;
            }
            int left=len/2-1,right = len/2;
            while(left>=0&&right<str.length()){
                if (map.get(str.charAt(left)-'0')!=str.charAt(right)-'0') {
                    System.out.println("NO");
                    break;
                }
                left--;
                right++;
            }
            if (left<0&&right>=str.length()){
                System.out.println("YES");
            }

        }
    }
}
