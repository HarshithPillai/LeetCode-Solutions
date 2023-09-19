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
        //int[][] dp = new int[n+1][2];
        int canbuyprev=0,canbuycurr=0,notbuyprev=0,notbuycurr=0;
        for(int i=n-1;i>=0;i--) {
            for(int j=0;j<2;j++) {
                if(j==1){// can buy
                    canbuycurr=Math.max(canbuyprev,notbuyprev-prices[i]);
                } else {
                    notbuycurr=Math.max(notbuyprev,prices[i]+canbuyprev);
                }
                canbuyprev=canbuycurr;
                notbuyprev=notbuycurr;
            }
        }
        return canbuycurr;
    }
}