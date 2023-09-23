class Solution {
    int[][] dp;
    public int helper(char[] a, char[] b, int i, int j) {
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a[i]==b[j]) {
            return dp[i][j]=helper(a,b,i-1,j-1);
        }
        int insert = 1 + helper(a,b,i,j-1);
        int delete = 1 + helper(a,b,i-1,j);
        int replace= 1 + helper(a,b,i-1,j-1);
        int res=Math.min(insert,Math.min(delete,replace));
        return dp[i][j]=res;
    }
    public int minDistance(String s, String t) {
        char[] a=s.toCharArray(), b=t.toCharArray();
        int n1=a.length,n2=b.length;
        dp=new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(a,b,n1-1,n2-1);
    }
}