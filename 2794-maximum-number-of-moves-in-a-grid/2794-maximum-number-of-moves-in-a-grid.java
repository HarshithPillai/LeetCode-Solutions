class Solution {
    int[] dx = {-1,0,1};
    int n, m;
    Integer[][] dp;
    public int helper(int[][] grid, int i, int j) {
        if(dp[i][j] != null) return dp[i][j];
        int res = 1;
        for(int k=0; k<3; k++) {
            int newr = i+dx[k], newc = j+1;
            if(newr < n && newc < m && newr >= 0 && newc >= 0 && grid[newr][newc] > grid[i][j]) {
                res = Math.max(res, 1 + helper(grid, newr, newc));
            }
        }
        return dp[i][j] = res;
    }
    public int maxMoves(int[][] grid) {
        int res = 0;
        n = grid.length;
        m = grid[0].length;
        dp = new Integer[n][m];
        for(int i=0; i<n; i++) {
            res = Math.max(res, helper(grid, i, 0));
        }
        return res-1;
    }
}