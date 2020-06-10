package bag;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author YoSaukit
 * @date 2020/1/29 19:58
 */
public class No71_SimplifyPath {
    public static void main(String[] args) {
        No71_SimplifyPath simplifyPath = new No71_SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a//b////c/d//././/.."));
    }
    public String simplifyPath(String path) {
        String res = "";
//        Stack<String> stack = new Stack<>();
        Deque<String> stack = new LinkedList<>();
//        String[] strs = path.split("/");
//        for (int i = 1; i < strs.length; i++) {
//            if (strs[i].equals(".")||strs[i].equals(""))continue;
//            if (strs[i].equals("..")){
//                if (!stack.isEmpty()){
//                    stack.pop();
//                }
//            }
//            else {
//                stack.add(strs[i]);
//            }
//        }
        for (String s :
                path.split("/")) {
            if (s.equals(".") || s.equals("")) continue;
            if (s.equals("..")){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.add(s);
            }
        }
        for (String str :
                stack) {
            res += "/"+str;
        }
        return res.length()==0?"/":res.substring(0,res.length()-1);
    }
}
