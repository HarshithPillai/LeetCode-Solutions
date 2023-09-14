class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int dp[]  = new int[c+1];
        int dp1[] = new int[c+1];
        int minyet1 = Integer.MAX_VALUE;
        for(int i=0;i<c;i++) {
            dp[i] = matrix[0][i];
            minyet1 = Math.min(minyet1,dp[i]);
        }
        dp[c]=minyet1;
        for(int i=1;i<r;i++) {
            int minyet = Integer.MAX_VALUE;
            for(int j=0;j<c;j++) {
                int up = Integer.MAX_VALUE;
                int upL = up, upR = up;
                up = dp[j];
                if(j>0) upL = dp[j-1];
                if(j<c-1) upR = dp[j+1];
                dp1[j] = matrix[i][j] + Math.min( up, Math.min(upL, upR));
                minyet = Math.min(minyet, dp1[j]);
            }
            dp1[c]=minyet;
            for(int j=0;j<=c;j++) dp[j]=dp1[j];
        }
        
        return dp[c];
    }
}