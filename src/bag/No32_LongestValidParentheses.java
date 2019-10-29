package bag;

import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2019/10/28 12:11
 */
public class No32_LongestValidParentheses {

    No20_ValidParentheses no20_validParentheses = new No20_ValidParentheses();

    public static void main(String[] args) {
        String s = "";
        No32_LongestValidParentheses no32_longestValidParentheses = new No32_LongestValidParentheses();
        System.out.println(no32_longestValidParentheses.longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {
        int len = s.length();
        int step = len%2==1?len-1:len;//偶数
        while(step>=0){
            for (int i = 0; i < s.length()-step+1; i++) {
                String str = s.substring(i,i+step);
                if (no20_validParentheses.isValid(str)){
                    return step;
                }
            }
            step-=2;
        }
        return step;
    }

    public int longestValidParentheses1(String s){
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')'&&!stack.empty()&&s.charAt(stack.peek())=='('){
                stack.pop();
            }else{
                if (stack.empty()){
                    max = Math.max(max,i);
                }else{
                    max = Math.max(max,i-stack.peek()-1);
                }
                stack.push(i);
            }
        }
        return stack.empty()?s.length():Math.max(max,s.length()-stack.peek()-1);
    }
}
