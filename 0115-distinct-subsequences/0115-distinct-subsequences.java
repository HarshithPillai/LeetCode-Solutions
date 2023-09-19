class Solution {
    public int helper(String s, String t, int ind1, int ind2, int[][] dp) {
        if(ind2<0) return 1;
        if(ind1<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        int take=0,dont=0;
        if(s.charAt(ind1)==t.charAt(ind2)) {
            take=helper(s,t,ind1-1,ind2-1,dp);
        }
        dont=helper(s,t,ind1-1,ind2,dp);
        dp[ind1][ind2]=take+dont;
        return take+dont;
    }
    public int numDistinct(String s, String t) {
        int n1=s.length(),n2=t.length();
        int[][] dp=new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(s,t,n1-1,n2-1,dp);
    }
}