class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int dp[][] = new int[r][c];
        for(int i=0;i<c;i++) dp[0][i] = matrix[0][i];
        for(int i=1;i<r;i++) {
            for(int j=0;j<c;j++) {
                int up = Integer.MAX_VALUE;
                int upL = up, upR = up;
                up = dp[i-1][j];
                if(j>0) upL = dp[i-1][j-1];
                if(j<c-1) upR = dp[i-1][j+1];
                dp[i][j] = matrix[i][j] + Math.min( up, Math.min(upL, upR));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<c;i++) min = Math.min(min,dp[r-1][i]);
        return min;
    }
}