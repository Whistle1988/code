package targetOffer.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qiuxiujie
 * @date 2020/9/17 19:18
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        List<String> resList = new ArrayList<>();
        String[] strings = str.split(" ");
        for (String string : strings) {
            boolean zero = true;
            for (int i = 0; i < string.length(); i++) {
                if ('1' <= string.charAt(i) && string.charAt(i) <= '3') {
                    for (int j = 0; j < i; j++) {
                        if (string.charAt(j)!='0'){
                            zero = false;
                        }
                    }
                    if (i + 4 < string.length() && Character.isDigit(string.charAt(i + 4))) {
                        continue;
                    }
                    if (i - 1 >= 0 && '1' <= string.charAt(i-1) && string.charAt(i-1) <= '9'&&zero) {
                        continue;
                    }
                    if (Character.isDigit(string.charAt(i + 1))
                            && Character.isDigit(string.charAt(i + 2))
                            && Character.isDigit(string.charAt(i + 3))
                            && string.substring(i, i + 4).compareTo("1000") >= 0
                            && string.substring(i, i + 4).compareTo("3999") <= 0) {
                        resList.add(string.substring(i, i + 4));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resList.size(); i++) {
            sb.append(resList.get(i));
            sb.append(" ");
        }
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }
}
