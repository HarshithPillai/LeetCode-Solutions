class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp = new int[n+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                int dont = dp[i-1][j];
                int take = 0;
                if(j-coins[i-1]>=0) {
                    take = dp[i][j-coins[i-1]];
                }
                dp[i][j]=take+dont;
            }
        }
        return dp[n][amount];
    }
}