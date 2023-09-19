class Solution {
    public int helper(char[] s, char[] t, int ind1, int ind2, int[][] dp) {
        if(ind2<0) return 1;
        if(ind1<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        int take=0,dont=0;
        if(s[ind1]==t[ind2]) {
            take=helper(s,t,ind1-1,ind2-1,dp);
        }
        dont=helper(s,t,ind1-1,ind2,dp);
        
        return dp[ind1][ind2]=take+dont;
    }
    public int numDistinct(String s1, String t1) {
        int n1=s1.length(),n2=t1.length();
        char[] s=s1.toCharArray(),t=t1.toCharArray();
        int[][] dp=new int[n1+1][n2+1];
        //for(int[] i:dp) Arrays.fill(i,-1);
        for (int j = 0; j <= n1; j++) dp[j][0] = 1;
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                if(s[i-1]==t[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }
                dp[i][j]+=dp[i-1][j];
            }
        }
        return dp[n1][n2];
    }
}