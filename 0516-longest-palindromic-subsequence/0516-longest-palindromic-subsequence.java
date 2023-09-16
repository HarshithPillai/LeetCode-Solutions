class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        char[] sarr = s.toCharArray();
        char[] sarr1 = new char[n];
        for(int i=n-1;i>=0;i--) sarr1[i]=sarr[n-i-1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(sarr[i-1] == sarr1[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}