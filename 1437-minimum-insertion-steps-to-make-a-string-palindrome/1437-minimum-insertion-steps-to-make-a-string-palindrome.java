class Solution {
    public int minInsertions(String s) {
        char[] a=s.toCharArray(), b=s.toCharArray();
        int n=s.length(), i1=0, j1=n-1;
        while(i1<j1) {
            char temp=b[i1];
            b[i1]=b[j1];
            b[j1]=temp;
            i1++;j1--;
        }
        int[][] dp = new int [n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(a[i-1]==b[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][n];
    }
}