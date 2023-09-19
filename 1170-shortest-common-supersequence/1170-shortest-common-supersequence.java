class Solution {
    public String shortestCommonSupersequence(String a1, String b1) {
        int m=a1.length(), n=b1.length();
        char[] a=a1.toCharArray(), b=b1.toCharArray();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a[i-1]==b[j-1])
                    dp[i][j]=1+dp[i-1][j-1];
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int len = m+n-(dp[m][n]);
        char[] lcs = new char[dp[m][n]];
        char[] extra = new char[len-dp[m][n]];
        int extraInd = len-dp[m][n]-1;
        int ind=dp[m][n]-1;
        int x=m,y=n;
        
        StringBuilder input1 = new StringBuilder();
        while(x>0 && y>0) {
            if(a[x-1]==b[y-1]) {
                input1.append(a[x-1]);
                x--;y--;
            } else if(dp[x-1][y] > dp[x][y-1]) {
                input1.append(a[x-1]); x--;
            } else {
                input1.append(b[y-1]); y--;
            }
        }
        while(x>0) {
            input1.append(a[x-1]);x--;
        }
        while(y>0) {
            input1.append(b[y-1]);y--;
        }

        return input1.reverse().toString();
    }
}