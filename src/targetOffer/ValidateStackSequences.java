package targetOffer;

import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2020/4/8 17:47
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0,len = pushed.length; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && index < len && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
