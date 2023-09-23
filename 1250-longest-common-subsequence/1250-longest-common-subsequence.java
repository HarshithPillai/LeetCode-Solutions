class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(), n2=text2.length();
        char[] arr=text1.toCharArray(), barr=text2.toCharArray();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                if(arr[i-1]==barr[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}