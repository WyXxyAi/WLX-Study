package Algorithm.Primary;

import java.util.Map;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length<2){
            return 0;
        }
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {65,4,654,564,564,564,65,65,56,464,987,97,465,4};
        System.out.println(new maxProfit().maxProfit(prices));
    }
}
