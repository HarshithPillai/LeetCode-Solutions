class Solution {
    int[][] dp;
    public int helper(int[] prices, int ind, int canBuy, int n) {
        if(ind==n) return 0;
        if(dp[ind][canBuy]!=-1) return dp[ind][canBuy];
        if(canBuy==1) {
            return dp[ind][canBuy]=Math.max(helper(prices,ind+1,1,n), -prices[ind]+helper(prices,ind+1,0,n));
        } else {
            return dp[ind][canBuy]=Math.max(helper(prices,ind+1,0,n), prices[ind]+helper(prices,ind+1,1,n));
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp = new int[n+1][2];
        //for(int[] i:dp) Arrays.fill(i,-1);
        for(int ind=n-1;ind>=0;ind--) {
            for(int canBuy=0;canBuy<2;canBuy++) {
                if(canBuy==1) {
                    dp[ind][canBuy]=Math.max(dp[ind+1][1], -prices[ind]+dp[ind+1][0]);
                } else {
                    dp[ind][canBuy]=Math.max(dp[ind+1][0], prices[ind]+dp[ind+1][1]);
                }
            }
        }
        return dp[0][1];
    }
}