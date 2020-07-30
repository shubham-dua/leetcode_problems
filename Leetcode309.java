// maximum profit
class Solution {
    public int maxProfit(int[] prices) {
        int[][] max_profit = new int[prices.length][2];
        return maxProfitHelper(0, 0, prices, 0, max_profit);
    }
    public int maxProfitHelper(int profit, int day, int[] prices, int state, int[][] max_profit){
        if(day>=prices.length)
            return profit;
        
        if(max_profit[day][state] != 0)
            return max_profit[day][state];
        
        // if we can buy on that day
        if(state == 0){
            profit = Math.max(maxProfitHelper(profit, day+1, prices, 1, max_profit)-prices[day], maxProfitHelper(profit, day+1, prices, 0, max_profit));
        }
        // if we can sell on that day or it is a cooldown day
        else{
            profit = Math.max(maxProfitHelper(profit, day+2, prices, 0, max_profit)+prices[day], maxProfitHelper(profit, day+1, prices, 1, max_profit));
        }
        
        max_profit[day][state] = profit;
                              
        return profit;
        
    }
}
