class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,n=prices.length;
        int minyet=Integer.MAX_VALUE,maxyet=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(prices[i]<minyet) minyet=prices[i];
            
            profit=Math.max(profit,prices[i]-minyet);
        }
        return profit;
    }
}