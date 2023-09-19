class Solution {
    public int helper(char[] sarr, char[] tarr, int i, int j,int[][] dp) {
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int take=0;
        if(sarr[i]==tarr[j]) {
            take = helper(sarr,tarr,i-1,j-1,dp);
        }
        int dont = helper(sarr, tarr, i-1, j,dp);
        int res = take+dont;
        dp[i][j]=res;
        return res;
    }
    public int numDistinct(String s, String t) {
        int n1=s.length(),n2=t.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        char[] sarr=s.toCharArray(), tarr=t.toCharArray();
        return helper(sarr,tarr,n1-1,n2-1,dp);
    }
}