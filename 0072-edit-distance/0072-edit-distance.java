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
        for(int i=0;i<=n1;i++) {
            for(int j=0;j<=n2;j++) {
                if(i==0 && j==0) continue;
                if(i==0) dp[i][j]=j;
                else if(j==0) dp[i][j]=i;
                else {
                    if(a[i-1]==b[j-1]) {
                        dp[i][j]=dp[i-1][j-1];
                    } else {
                        int insert = 1 + dp[i][j-1];
                        int delete = 1 + dp[i-1][j];
                        int replace= 1 + dp[i-1][j-1];
                        int res=Math.min(insert,Math.min(delete,replace));
                        dp[i][j]=res;
                    }
                }
            }
        }
        return dp[n1][n2];
    }
}