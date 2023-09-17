class Solution {
    public int minPathSum(int[][] grid) {
        int r=grid.length,c=grid[0].length;
        int[][] dp = new int[r][c];
        dp[0][0]=grid[0][0];
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(i==0 && j==0) continue;
                dp[i][j]=grid[i][j] + Math.min(
                    ((i>0)?dp[i-1][j]:Integer.MAX_VALUE) , ((j>0)?dp[i][j-1]:Integer.MAX_VALUE)
                );
            }
        }
        return dp[r-1][c-1];
    }
}