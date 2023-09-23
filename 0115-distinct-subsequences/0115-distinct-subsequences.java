class Solution {
    int[][] dp;
    public int helper(char[] a, char[] b, int i, int j) {
        if(j==-1) return 1;
        if(i==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res=0;
        if(a[i]==b[j]) {
            res=helper(a,b,i-1,j-1);
        }
        res+=helper(a,b,i-1,j);
        return dp[i][j]=res;
    }
    public int numDistinct(String s, String t) {
        char[] a=s.toCharArray(), b=t.toCharArray();
        int n1=a.length,n2=b.length;
        dp = new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(a,b,n1-1,n2-1);
    }
}