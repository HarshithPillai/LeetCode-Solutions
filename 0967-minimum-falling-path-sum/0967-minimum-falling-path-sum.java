class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) dp[0][i]=matrix[0][i];

        for(int i=1;i<n;i++) {
            for(int j=0;j<n;j++) {
                int res=(int)(1e9);
                for(int k=-1;k<2;k++) {
                    if(j+k>=0 && j+k<n) {
                        res=Math.min(res,dp[i-1][j+k]);
                    }
                }
                dp[i][j]=res+matrix[i][j];
            }
        }
        int min=(int)(1e9);
        for(int i=0;i<n;i++) min=Math.min(min, dp[n-1][i]);
        return min;
    }
}