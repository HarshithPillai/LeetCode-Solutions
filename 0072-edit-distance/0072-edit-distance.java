class Solution {
    public int helper(char[] sarr, char[] tarr, int i, int j,int[][] dp) {
        if(i==-1) return j+1;
        if(j==-1) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(sarr[i]==tarr[j]) {
            return helper(sarr,tarr,i-1,j-1,dp);
        }
        int insert = 1 + helper(sarr,tarr,i,j-1,dp);
        int delete = 1 + helper(sarr,tarr,i-1,j,dp);
        int replace = 1+ helper(sarr,tarr,i-1,j-1,dp);
        int res = Math.min(insert,Math.min(delete,replace));
        return dp[i][j] = res;
    }
    public int minDistance(String word1, String word2) {
        char[] sarr=word1.toCharArray(), tarr=word2.toCharArray();
        int n1=sarr.length,n2=tarr.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(sarr,tarr,n1-1,n2-1,dp);
    }
}