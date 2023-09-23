class Solution {
    public int minDistance(String word1, String word2) {
        char[] a=word1.toCharArray(), b=word2.toCharArray();
        int n1=a.length, n2=b.length;
        int[][] dp = new int [n1+1][n2+1];
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                if(a[i-1]==b[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n1 - dp[n1][n2] + n2 - dp[n1][n2];
    }
}