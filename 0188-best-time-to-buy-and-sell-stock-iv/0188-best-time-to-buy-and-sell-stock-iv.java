class Solution {
    int[][][] dp;
    public int helper(int[] prices, int ind, int canBuy, int total, int n) {
        if(ind==n) return 0;
        if(total==0) return 0;
        if(dp[ind][canBuy][total]!=-1) return dp[ind][canBuy][total];
        int res=0;
        if(canBuy==1) {
            res=Math.max(helper(prices,ind+1,1,total,n),-prices[ind]+helper(prices,ind+1,0,total,n));
        } else {
            res=Math.max(helper(prices,ind+1,0,total,n), prices[ind]+helper(prices,ind+1,1,total-1,n));
        }
        return dp[ind][canBuy][total]=res;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        dp=new int[n+1][2][k+1];
        for(int i=0;i<=n;i++) {
            for(int j[]:dp[i]) Arrays.fill(j,-1);
        }
        return helper(prices,0,1,k,n);
    }
}