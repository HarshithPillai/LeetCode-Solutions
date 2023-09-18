class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        char[] sarr=s.toCharArray();
        char[] tarr=s.toCharArray();
        for(int i=0;i<n;i++) tarr[i]=sarr[n-1-i];
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(sarr[i-1]==tarr[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                dp[i][j]=Math.max(dp[i][j],Math.max(dp[i][j-1],dp[i-1][j]));
            }
        }
        return n-dp[n][n];
    }
}