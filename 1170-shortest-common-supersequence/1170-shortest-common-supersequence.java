class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        char[] a=str1.toCharArray(),b=str2.toCharArray();
        int n1=a.length, n2=b.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++) {
            for(int j=1;j<=n2;j++) {
                if(a[i-1]==b[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int x=n1, y=n2;
        while(x>0 && y>0) {
            if(a[x-1]==b[y-1]) {
                sb.append(a[x-1]);
                x--;y--;
            } else {
                if(dp[x][y-1]>dp[x-1][y]) {
                    sb.append(b[y-1]);
                    y--;
                } else {
                    sb.append(a[x-1]);
                    x--;
                }
            }
        }
        while(x>0) {
            sb.append(a[x-1]);
            x--;
        }
        while(y>0) {
            sb.append(b[y-1]);
            y--;
        }
        return sb.reverse().toString();
    }
}