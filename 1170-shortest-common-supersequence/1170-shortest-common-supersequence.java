class Solution {
    public String shortestCommonSupersequence(String a, String b) {
                int m=a.length(), n=b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(a.charAt(i-1)==b.charAt(j-1))
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
        String ans="";
        while(x>0 && y>0) {
            if(a.charAt(x-1)==b.charAt(y-1)) {
                ans+=a.charAt(x-1);
                x--;y--;
            } else if(dp[x-1][y] > dp[x][y-1]) {
                ans+=a.charAt(x-1); x--;
            } else {
                ans+=b.charAt(y-1); y--;
            }
        }
        while(x>0) {
            ans+=a.charAt(x-1);x--;
        }
        while(y>0) {
            ans+=b.charAt(y-1);y--;
        }
        
 
        StringBuilder input1 = new StringBuilder();
 
        // append a string into StringBuilder input1
        input1.append(ans);
 
        // reverse StringBuilder input1
        return input1.reverse().toString();
    }
}