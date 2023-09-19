class Solution {
    int n;
    public int helper(int[] prices, int i, int cap, int[][] dp) {
        if(cap==-1 || i==n) return 0;
        if(dp[i][cap]!=-1) return dp[i][cap];
        int res=0;
        if(cap%2==1) {
            res=Math.max(helper(prices,i+1,cap,dp),-prices[i]+helper(prices,i+1,cap-1,dp));
        } else {
            res=Math.max(helper(prices,i+1,cap,dp),helper(prices,i+1,cap-1,dp)+prices[i]);
        }
        return dp[i][cap]=res;
    }
    public int maxProfit(int[] prices) {
        n=prices.length;
        int[][] dp=new int[n+1][4];
        for(int[] j:dp) Arrays.fill(j,-1);
        return helper(prices,0,3,dp);
    }
}