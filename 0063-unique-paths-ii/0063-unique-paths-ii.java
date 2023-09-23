class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int r=grid.length, c=grid[0].length;
        int[] dp=new int[c];
        if(grid[0][0]==0) dp[0]=1;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(i==0 && j==0) continue;
                if(grid[i][j]==0) {
                    dp[j]=((i>0)?dp[j]:0)+((j>0)?dp[j-1]:0);
                } else dp[j]=0;
            }
        }
        return dp[c-1];
    }
}