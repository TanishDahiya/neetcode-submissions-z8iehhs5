class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buyPrice = prices[0];
        int maxProfit = 0;

        for(int i =0;i<n;i++){
            if(buyPrice > prices[i]){
                buyPrice = prices[i];
            }else{
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
        }

        return maxProfit;
    }
}
