package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YoSaukit
 * @date 2019/10/16 11:08
 */
public class No22_GenerateParentheses {
    public static void main(String[] args) {
        No22_GenerateParentheses no22_generateParentheses = new No22_GenerateParentheses();
        System.out.println(Arrays.toString(no22_generateParentheses.generateParenthesis(4).toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        return list;
    }
    public void backtrack(List<String> list,String str,int open,int close,int max){
        if (str.length() == max*2){
            list.add(str);
            return;
        }
        if (open < max)
            backtrack(list,str+"(",open+1,close,max);
        if (close<open)
            backtrack(list,str+")",open,close+1,max);
    }
}
