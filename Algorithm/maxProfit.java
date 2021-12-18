package Algorithm;

import java.util.Map;

public class maxProfit {
    //无限交易无交易手续费
    public int maxProfit01(int[] prices) {
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

    //买入、卖出手续费为交易金额10％
    public double maxProfit02(int[] prices) {
        double res=0,min=0,max=0,srvMoney = 0;
        boolean posFlag=false;
        for (int i = 1; i < prices.length; i++) {
            if(posFlag){
                if(prices[i]<prices[i-1]){
                    max = prices[i-1];
                    srvMoney += prices[i-1]*0.1;
                    res += max-min;
                    posFlag = false;
                }
            }else {
                if(prices[i]>prices[i-1]) {
                    min = prices[i - 1];
                    srvMoney += prices[i-1]*0.1;
                    posFlag = true;
                }
            }
        }
        if (posFlag&&prices[prices.length-1]>min){
            res += prices[prices.length-1]-min;
            srvMoney += prices[prices.length-1]*0.1;
            posFlag = false;
        }
        res -= srvMoney;
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new maxProfit().maxProfit01(prices));
        System.out.println(new maxProfit().maxProfit02(prices));
    }

}
