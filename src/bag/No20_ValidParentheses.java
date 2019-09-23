package bag;

import java.util.Stack;

/**
 * 栈
 */
public class No20_ValidParentheses {
    public static void main(String[] args) {
        String s = "(]";
        No20_ValidParentheses no20_validParentheses = new No20_ValidParentheses();
        System.out.println(no20_validParentheses.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else {
                switch (s.charAt(i)) {
                    case '{':
                    case '[':
                    case '(':
                        stack.push(s.charAt(i));
                        break;
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                }
            }
        }
        if (stack.isEmpty())return true;
        else return false;
    }

}
