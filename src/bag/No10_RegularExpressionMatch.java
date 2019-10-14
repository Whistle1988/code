package bag;

/**
 * @author YoSaukit
 * @date 2019/10/10 10:16
 * 好难一动态规划
 */
public class No10_RegularExpressionMatch {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        if (s==null&&p!=null)return false;
        if (s!=null&&p==null)return false;
        int x=0,y=0;
        while (x < s.length()&&y<p.length()) {
            if (s.charAt(x)==p.charAt(y)&&y<p.length()-1){
                if (p.charAt(y)=='*'){

                }

            }else{
                if (p.charAt(y)!='*'&&p.charAt(y)!='.'){
                    if (y<p.length()-1&&p.charAt(y+1)=='*')
                    {
                        y=y+2;
                        x++;
                    }
                }
            }
        }
        if (x>=s.length()&&y>=p.length())return true;
        else return false;
    }
}
