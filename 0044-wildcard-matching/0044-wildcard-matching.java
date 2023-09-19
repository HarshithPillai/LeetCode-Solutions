class Solution {
    public int helper(char[] pat, char[] str, int i, int j, int[][] dp) {
        if(i==-1 && j==-1) return 1;
        if(j==-1) {
            while(i>=0 && pat[i]=='*') i--;
            if(i==-1) return 1;
            else return 0;
        }
        if(i==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(pat[i]==str[j] || pat[i]=='?') {
            return dp[i][j] = helper(pat,str,i-1,j-1,dp);
        }
        if(pat[i]=='*') {
            return dp[i][j] = Math.max(helper(pat,str,i-1,j,dp),helper(pat,str,i,j-1,dp));
        }
        return dp[i][j]=0;
    }
    public boolean isMatch(String str, String pattern) {
        int n1=pattern.length(), n2=str.length();
        char[] pat=pattern.toCharArray(), s=str.toCharArray();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        
        return (helper(pat, s, n1-1, n2-1,dp)==1);
    }
}