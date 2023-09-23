class Solution {
    int[][] dp;
    public int helper(char[] arr, char[] pat, int i, int j) {
        if(i==-1 && j==-1) return 1;
        if(i==-1) {
            while(j!=-1 && pat[j]=='*') j--;
            if(j==-1) return 1;
            return 0;
        }
        if(i==-1 || j==-1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(arr[i]==pat[j] || pat[j]=='?') {
            return dp[i][j]=helper(arr,pat,i-1,j-1);
        } else if (pat[j]=='*') {
            return dp[i][j]=Math.max(helper(arr,pat,i,j-1),
                                    helper(arr,pat,i-1,j));
        }
        return dp[i][j]=0;
    }
    public boolean isMatch(String s, String p) {
        char[] arr=s.toCharArray(), pat=p.toCharArray();
        int n1=s.length(), n2=p.length();
        dp = new int[n1+1][n2+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return (helper(arr,pat,n1-1,n2-1)==1);
    }
}