class Solution {
    int r, c, dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1};
    Integer[][] dp;
    public int helper(int[][] matrix, int i, int j, int last) {
        if(dp[i][j] != null) return dp[i][j];
        int res = 0;
        for(int k=0; k<4; k++) {
            int newr = i+dx[k], newc = j+dy[k];
            if(newr<r && newc<c && newr>=0 && newc>=0 && matrix[newr][newc]>last) {
                res = Math.max(res, helper(matrix, newr, newc, matrix[newr][newc]) + 1);
            }
        }
        return dp[i][j] = res;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        r = matrix.length;
        c = matrix[0].length;
        
        dp = new Integer[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                res = Math.max(res, helper(matrix, i, j, matrix[i][j])+1);
            }
        }
        return res;
    }
}