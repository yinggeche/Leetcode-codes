class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1){
            return 0;
        }
        // Max Profit
        // when first buy stock, first sell stock
        // second buy stock, second sell stock
        // at day i
        // 在这一天第一次买、卖，第二次买、卖的最大利润
        // 实际上这一天不一定会买卖stock
        // 所有的max profit都是，截止这天的max profit（余额）
        int frstBuy = Integer.MIN_VALUE; //截止到这一天，我能花最少的钱买的stock
        int frstSell = 0; // 截止到这一天，我能得到最多的profit
        int secBuy = Integer.MIN_VALUE;
        int secSell = 0;
        for (int i = 0; i < prices.length; i++){
            frstBuy = Math.max(frstBuy, -prices[i]);
            // 第一次买的最大利润，一般都是负的，因此和min_value比较
            // 减去当天的价格
            // **为什么要取max,想用尽可能少的钱买stock,支出之后剩的钱要尽可能多
            frstSell = Math.max(frstSell, frstBuy+prices[i]);
            // 第一次卖的最大利润，第一次买的最大利润加上当天的价格
            secBuy = Math.max(secBuy, frstSell-prices[i]);
            // 仅当＞0才会更新，保证 第二次买入不会与第一次卖出为同一天。而sell1为历史记录保证第二次买入比第一次卖出晚。
            secSell = Math.max(secSell, secBuy+prices[i]);
            // 若第二轮买卖为同一天，则不会更新。此操作自然保证sell2为买卖至多两次的最优利润。
        }
        return secSell;
    }
}
/*
 0 1 2 3 4 5 6 7
[3,3,5,0,0,3,1,4]
Init  firstBuy: -2147483648 firstSell: 0 secondBuy: -2147483648 secondSell: 0
No. 0 firstBuy: -3 firstSell: 0 secondBuy: -3 secondSell: 0
No. 1 firstBuy: -3 firstSell: 0 secondBuy: -3 secondSell: 0
No. 2 firstBuy: -3 firstSell: 2 secondBuy: -3 secondSell: 2
No. 3 firstBuy: 0 firstSell: 2 secondBuy: 2 secondSell: 2
No. 4 firstBuy: 0 firstSell: 2 secondBuy: 2 secondSell: 2
No. 5 firstBuy: 0 firstSell: 3 secondBuy: 2 secondSell: 5
No. 6 firstBuy: 0 firstSell: 3 secondBuy: 2 secondSell: 5
No. 7 firstBuy: 0 firstSell: 4 secondBuy: 2 secondSell: 6
*/
