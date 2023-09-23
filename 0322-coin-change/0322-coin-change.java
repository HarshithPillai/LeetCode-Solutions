class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int j=1;j<=amount;j++) dp[0][j]=(int)(1e9);
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                dp[i][j]=dp[i-1][j];
                if(j-coins[i-1]>=0)dp[i][j]=Math.min(dp[i][j],1+dp[i][j-coins[i-1]]);
            }
        }
        if(dp[n][amount]==(int)(1e9)) return -1;
        return dp[n][amount];
    }
}