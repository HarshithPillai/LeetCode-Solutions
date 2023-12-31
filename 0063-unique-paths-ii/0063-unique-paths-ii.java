class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int r=grid.length, c=grid[0].length;
        int[][] dp=new int[r][c];
        if(grid[0][0]==0) dp[0][0]=1;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(i==0 && j==0) continue;
                if(grid[i][j]==0) {
                    dp[i][j]=((i>0)?dp[i-1][j]:0)+((j>0)?dp[i][j-1]:0);
                }
            }
        }
        return dp[r-1][c-1];
    }
}