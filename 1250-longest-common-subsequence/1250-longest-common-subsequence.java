class Solution {
    public int helper(String s1, String s2, int i1, int i2, int[][] dp) {
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int res = 0;
        if(s1.charAt(i1)==s2.charAt(i2)) {
            res = 1 + helper(s1,s2,i1-1,i2-1,dp);
        }
        int first = helper(s1,s2,i1-1,i2,dp);
        int second = helper(s1,s2,i1,i2-1,dp);
        res = Math.max(res, Math.max(first, second));
        dp[i1][i2] = res;
        return res;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length(), n2=text2.length();
        int[] dp = new int[n2+1];
        //for(int[] i:dp) Arrays.fill(i,-1);
        for(int i=1;i<=n1;i++) {
            int[] dp1 = new int[n2+1];
            for(int j=1;j<=n2;j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp1[j]=1+dp[j-1];
                } else {
                    dp1[j] = Math.max(dp[j], dp1[j-1]);
                }
            }
            dp = dp1;
        }
        return dp[n2];
    }
}