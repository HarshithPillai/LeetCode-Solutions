class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length, c=grid[0].length;
        int dp[][] = new int[r][c];
        dp[0][0]=grid[0][0];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(i==0 && j==0) continue;
                else {
                    int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                    if(i>0) left = dp[i-1][j];
                    if(j>0) up = dp[i][j-1];
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }
        return dp[r-1][c-1];
    }
}