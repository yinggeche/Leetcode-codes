class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1){
            return 0;
        }
        int minPrice = prices[0];
        // 记录【今天之前买入的最小值】
        int maxProfit = 0;
        //计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
        for(int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
            // 每次都比较最大收益和最小价格
        }
        return maxProfit;
    }
}
/*
记录【今天之前买入的最小值】
计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
比较【每天的最大获利】，取最大值即可
*/
