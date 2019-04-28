import Strings.ReverseInteger;

class Solution {
    public int myAtoi(String str){
        int result=0;
        if(str==null||str.length()==0)return result;
        str=str.trim();
        if(str.length()==0)return 0;
        char firstChar=str.charAt(0);
        if(firstChar!='+'&&firstChar!='-'&&!Character.isDigit(firstChar)){
            return result;
        }
        boolean isNegative=false;
        if(firstChar=='+'||firstChar=='-'){
            str = str.substring(1);
            if(firstChar=='-')isNegative=true;
        }
        int index = 0;
        while(index < str.length()&&Character.isDigit(str.charAt(index))){
            int temp = result *10 + Integer.parseInt(String.valueOf(str.charAt(index)));
            if(temp/10!=result){
                //check if overflow
                return isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            result = temp;
            index++;
        }
        if (isNegative) {
            result = -result;
        }
        return result;
    }

}
public class Main {
    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
        System.out.println(reverseInteger.reverse(-1));
    }



}
