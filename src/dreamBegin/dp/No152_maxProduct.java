package dreamBegin.dp;

/**
 * 乘积最大子数组
 * @author YoSaukit
 * @date 2020/5/18 20:58
 */
public class No152_maxProduct {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE,imax = 1,imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i],nums[i]);
            imin = Math.min(imin*nums[i],nums[i]);

            max = Math.max(max,imax);
        }
        return max;
    }

    /**
     * 股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //但是这个方法不好
//        int max = 0;
//        for (int i = 0; i < prices.length-1; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[i]<prices[j]){
//                    max = Math.max(max,prices[j]-prices[i]);
//                }
//            }
//        }
//        return max;
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0,min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }else{
                res = Math.max(res,prices[i]-min);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        No152_maxProduct maxProduct = new No152_maxProduct();
//        System.out.println(maxProduct.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(maxProduct.maxProfit(new int[]{7,6,4,3,1}));
    }
}
