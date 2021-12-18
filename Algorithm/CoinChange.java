package Algorithm;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int myAmount = amount;
        Arrays.sort(coins);
        int res = 0;
        for (int i = len-1; i >=0; i--) {
            if (i!=0){
                res = res+(myAmount/coins[i]);
                myAmount = myAmount%coins[i];
            }else {
                if (myAmount%coins[0]==0){
                    res = res+(myAmount/coins[0]);
                }else {
                    res = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        CoinChange coinChange = new CoinChange();
        int res = coinChange.coinChange(coins,amount);
        System.out.println(res);
        System.out.println(1%2);

    }
}
