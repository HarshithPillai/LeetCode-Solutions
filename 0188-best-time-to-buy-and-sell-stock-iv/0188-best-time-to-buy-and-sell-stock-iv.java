class Solution {
    int n;
    public int helper(int[] prices, int i, int canBuy, int cap, int[][][] dp) {
        if(cap==0 || i==n) return 0;
        if(dp[i][canBuy][cap]!=-1) return dp[i][canBuy][cap];
        int res=0;
        if(canBuy==1) {
            res=Math.max(helper(prices,i+1,1,cap,dp),-prices[i]+helper(prices,i+1,0,cap,dp));
        } else {
            res=Math.max(helper(prices,i+1,0,cap,dp),helper(prices,i+1,1,cap-1,dp)+prices[i]);
        }
        return dp[i][canBuy][cap]=res;
    }
    public int maxProfit(int k, int[] prices) {
        n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        for(int i=0;i<=n;i++) for(int[] j:dp[i]) Arrays.fill(j,-1);
        return helper(prices,0,1,k,dp);
    }
}