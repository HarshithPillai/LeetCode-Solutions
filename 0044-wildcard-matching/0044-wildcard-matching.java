class Solution {
    public int helper(char[] a, char[] b, int i, int j,int[][] dp) {
        if(i==-1 && j==-1) return 1;
        if(i==-1) {
            while(j>=0 && b[j]=='*') j--;
            if(j==-1) return 1;
            return 0;
        }
        if(j==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a[i]==b[j] || b[j]=='?') {
            return dp[i][j] = helper(a,b,i-1,j-1,dp);
        } else if(b[j]=='*') {
            return dp[i][j] = Math.max(helper(a,b,i-1,j,dp),helper(a,b,i,j-1,dp));
        }
        return dp[i][j]=0;
    }
    public boolean isMatch(String s, String p) {
        char[] sarr=s.toCharArray(), tarr=p.toCharArray();
        int n1=sarr.length,n2=tarr.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return (helper(sarr,tarr,n1-1,n2-1,dp)==1);
    }
}