package bag;

/**
 * @author YoSaukit
 * @date 2020/1/8 20:38
 */
public class No69_Sqrt {
    public int mySqrt(int x){
        if (x==0) return 0;
        int start = 1,end = x;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (mid <=x/mid && (mid + 1)>x/(mid+1))
                return mid;
            else if (mid > x / mid)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
