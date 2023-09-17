class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int[][] dp = new int[r][c];
        for(int j=0;j<c;j++) {
            dp[0][j]=matrix[0][j];
        }
        
        for(int i=1;i<r;i++) {
            for(int j=0;j<c;j++) {
                int min = Integer.MAX_VALUE;
                for(int k=-1;k<=1;k++) {
                    if(j+k>=0 && j+k<c) min=Math.min(min,dp[i-1][j+k]);
                }
                dp[i][j]=matrix[i][j]+min;
            }
        }
        int max=Integer.MAX_VALUE;
        for(int j=0;j<c;j++) max=Math.min(max,dp[r-1][j]);
        return max;
    }
}