class Solution {
    int transaction_fee, n1;
    int[][] dp;
    public int helper(int[] prices, int ind, int can) {
        if(ind==n1) return 0;
        if(dp[ind][can]!=-1) return dp[ind][can];
        if(can==1) {
            return dp[ind][can]=Math.max(helper(prices,ind+1,1),-prices[ind]+helper(prices,ind+1,0));
        } else {
            return dp[ind][can]=Math.max(helper(prices,ind+1,0), prices[ind]+helper(prices,ind+1,1)-transaction_fee);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        n1=n;
        transaction_fee=fee;
        dp = new int[n+1][2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(prices,0,1);
    }
}