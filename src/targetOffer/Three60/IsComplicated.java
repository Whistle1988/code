package targetOffer.Three60;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiuxiujie
 * @date 2020/9/11 21:10
 */
public class IsComplicated {
    public static boolean judge(String str) {
        if (str.length() < 8) {
            return false;
        }
        char[] ch = str.toCharArray();
        boolean hasNum = false, hasBig = false, hasSmall = false, hasParticular = false;
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] == ' ') {
                return false;
            } else if ('0' <= ch[i] && ch[i] <= '9') {
                hasNum = true;
            } else if ('a' <= ch[i] && ch[i] <= 'z') {
                hasSmall = true;
            } else if ('A' <= ch[i] && ch[i] <= 'Z') {
                hasBig = true;
            } else if (ch[i] == '_' || ch[i] == '^') {
                hasParticular = true;
            }
            if (hasNum && hasBig && hasSmall && hasParticular) {
                return true;
            }
        }
        return hasNum && hasBig && hasSmall && hasParticular;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Boolean> list = new ArrayList<>();
        while (in.hasNext()) {
            String str = in.next();
            list.add(judge(str));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)) {
                System.out.println("Ok");
            } else {
                System.out.println("Irregular password");
            }
        }
    }
}
