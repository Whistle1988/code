package bag;

/**
 * @author YoSaukit
 * @date 2019/12/30 10:20
 */
public class No67_AddBinary {
    public static void main(String[] args) {
        No67_AddBinary addBinary = new No67_AddBinary();
        System.out.println(addBinary.addBinary("1111","100"));
    }
    public String addBinary(String a, String b) {
//        int endA = a.length()-1,endB = b.length()-1,tmp=0;
//        StringBuilder sb = new StringBuilder();
//        while(endA>=0&&endB>=0){
//            sb.insert(0,(a.charAt(endA)-'0'+b.charAt(endB)-'0'+tmp)%2);
//            tmp = (a.charAt(endA)-'0'+b.charAt(endB)-'0'+tmp)/2;
//            endA--;
//            endB--;
//        }
//        if (endA<0){
//            while(endB>=0){
//                sb.insert(0,(b.charAt(endB)-'0'+tmp)%2);
//                tmp = (b.charAt(endB)-'0'+tmp)/2;
//                endB--;
//            }
//        }
//        else if (endB<0){
//            while(endA>=0){
//                sb.insert(0,(a.charAt(endA)-'0'+tmp)%2);
//                tmp = (a.charAt(endA)-'0'+tmp)/2;
//                endA--;
//            }
//        }
//        if (tmp!=0)sb.insert(0,tmp);
//        return sb.toString();
        //合并到一起
        StringBuilder sb = new StringBuilder();
        int i=a.length()-1,j=b.length()-1,carry=0;
        while(i>=0 || j>=0){
            int sum = carry;
            if (j>=0)sum+=b.charAt(j--)-'0';
            if (i>=0)sum+=a.charAt(i--)-'0';
            sb.append(sum%2);
            carry=sum/2;
        }
        if (carry!=0)sb.append(carry);
        return sb.reverse().toString();
    }
}
