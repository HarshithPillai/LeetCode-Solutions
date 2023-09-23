class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp = new int[amount+1];
        for(int j=1;j<=amount;j++) dp[j]=(int)(1e9);
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=amount;j++) {
                if(j-coins[i-1]>=0)dp[j]=Math.min(dp[j],1+dp[j-coins[i-1]]);
            }
        }
        if(dp[amount]==(int)(1e9)) return -1;
        return dp[amount];
    }
}