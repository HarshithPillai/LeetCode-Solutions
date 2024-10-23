class Solution {
    int[][] dp;
    // public int dfs(int s, int e) {
    //     if(e < s) return 0;
    //     if(e-s < 2) return e-s+1;
    //     if(dp[s][e] != null) return dp[s][e];
    //     int curr = dfs(s, e-1) + dfs(s+1, e);
    //     for(int i=s+1; i<e; i++) {
    //         curr += dfs(s, i-1) * dfs(i+1, e);
    //     }
    //     return dp[s][e] = curr;
    // }
    public int numTrees(int n) {
        dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            dp[i][i] = 1;
            if(i<n) dp[i][i+1] = 2;
        }
        for(int s = n; s>=1; s--) {
            for(int e = 1; e<=n; e++) {
                if(e-s < 2) continue;
                int curr = dp[s][e-1] + dp[s+1][e];
                for(int i=s+1; i<e; i++) {
                    curr += dp[s][i-1] * dp[i+1][e];
                }
                dp[s][e] = curr;
            }
        }
        return dp[1][n];
    }
}