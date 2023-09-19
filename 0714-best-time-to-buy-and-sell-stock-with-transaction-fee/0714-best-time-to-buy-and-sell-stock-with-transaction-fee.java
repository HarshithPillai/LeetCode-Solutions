class Solution {
    int n,f;
    public int helper(int[] prices, int i, int canbuy, int[][] dp) {
        if(i>=n) return 0;
        if(dp[i][canbuy]!=-1) return dp[i][canbuy];
        if(canbuy==1) {
            return dp[i][canbuy] = Math.max(helper(prices,i+1,1,dp),helper(prices,i+1,0,dp)-prices[i]);
        } else {
            return dp[i][canbuy] = Math.max(helper(prices,i+1,0,dp),helper(prices,i+1,1,dp)+prices[i]-f);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        f=fee;
        n=prices.length;
        int[][] dp = new int[n+1][2];
        for(int i[]:dp) Arrays.fill(i,-1);
        return helper(prices,0,1,dp);
    }
}