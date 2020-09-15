package targetOffer.xiaomi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author qiuxiujie
 * @date 2020/9/15 19:24
 */
public class Test1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '[') || (s.charAt(i) == '{')) {
                stack.push(s.charAt(i));
            }
            if ((s.charAt(i) == ')') || (s.charAt(i) == ']') || (s.charAt(i) == '}')) {
                if (stack.empty()) {
                    return false;
                }
                if ((stack.peek() == '(' && s.charAt(i) == ')') || (stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '{' && s.charAt(i) == '}')) {     // 如果栈顶元素和下一个右括号相匹配，则将其栈顶元素出栈
                    stack.pop();
                }
            }
        }
        if (stack.empty()) {   // 遍历循环结束后，如果发现栈里为空，则证明括号匹配完毕；否则括号不匹配
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            String string = in.nextLine();
            System.out.println(isValid(string));
        }
    }
}

