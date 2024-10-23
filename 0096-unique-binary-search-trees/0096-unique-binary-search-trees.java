class Solution {
    Integer[][] dp;
    public int dfs(int s, int e) {
        if(e < s) return 0;
        if(e-s < 2) return e-s+1;
        if(dp[s][e] != null) return dp[s][e];
        int curr = dfs(s, e-1) + dfs(s+1, e);
        for(int i=s+1; i<e; i++) {
            curr += dfs(s, i-1) * dfs(i+1, e);
        }
        return dp[s][e] = curr;
    }
    public int numTrees(int n) {
        dp = new Integer[n+1][n+1];
        return dfs(1, n);
    }
}