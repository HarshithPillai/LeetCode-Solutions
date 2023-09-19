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
        dp[ind1][ind2]=take+dont;
        return take+dont;
    }
    public int numDistinct(String s1, String t1) {
        int n1=s1.length(),n2=t1.length();
        char[] s=s1.toCharArray(),t=t1.toCharArray();
        int[][] dp=new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(s,t,n1-1,n2-1,dp);
    }
}