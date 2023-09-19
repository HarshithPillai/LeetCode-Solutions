class Solution {
    public int helper(int[] prices, int i, int canBuy, int n, int[][] dp) {
        if(i==n) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        int res=0;
        if(canBuy==1) {
            res=helper(prices,i+1,0,n, dp)-prices[i];
            res=Math.max(res,helper(prices,i+1,1,n, dp));
        } else {
            res=prices[i] + helper(prices,i+1,1,n, dp);
            res=Math.max(res,helper(prices,i+1,0,n, dp));
        }
        return dp[i][canBuy]=res;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(prices, 0, 1, n, dp);
    }
}