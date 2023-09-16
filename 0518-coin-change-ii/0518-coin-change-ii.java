class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                int take = 0;
                if(j-coins[i-1]>=0) {
                    dp[j] += dp[j-coins[i-1]];
                }
                //dp[j]=take+dont;
            }
        }
        return dp[amount];
    }
}