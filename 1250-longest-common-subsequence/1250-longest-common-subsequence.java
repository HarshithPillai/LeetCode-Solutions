class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] sarr = text1.toCharArray(), tarr=text2.toCharArray();
        int s=sarr.length, t=tarr.length;
        int[][] dp = new int[s+1][t+1];
        for(int i=1;i<=s;i++) {
            for(int j=1;j<=t;j++) {
                if(sarr[i-1]==tarr[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                dp[i][j]=Math.max(dp[i][j], Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[s][t];
    }
}