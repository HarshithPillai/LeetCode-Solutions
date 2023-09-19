class Solution {
    public int helper(char[] s, char[] t, int i, int j, int[][] dp) {
        // insert
        if(i==-1 && j==-1) return 0;
        if(j==-1) return i+1;
        if(i==-1) return j+1;
        int take = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s[i]==t[j]) return dp[i][j]=helper(s,t,i-1,j-1,dp);
        int insert = helper(s,t,i,j-1,dp);
        int delete = helper(s,t,i-1,j,dp);
        int replace = helper(s,t,i-1,j-1,dp);
        int res = 1 + Math.min(Math.min(replace,delete),insert);
        dp[i][j]=res;
        return res;
    }
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        char[] s=word1.toCharArray(), t=word2.toCharArray();
        
        int n1=s.length,n2=t.length;
        if(n1==0) return n2;
        int[][] dp = new int[n1+1][n2+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(s,t,n1-1,n2-1,dp);
    }
}