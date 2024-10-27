class Solution {
    public int countSquares(int[][] matrix) {
        int sum = 0, n = matrix.length, m = matrix[0].length, dp[][] = new int[n][m];
        for(int i=0; i<n; i++) {
            dp[i][0] = matrix[i][0];
            sum+=matrix[i][0];
        }
        for(int i=1; i<m; i++) {
            dp[0][i] = matrix[0][i];
            sum+=matrix[0][i];
        }
        for(int i=1; i<n; i++) {
            for(int j = 1; j<m; j++) {
                if(matrix[i][j] == 1) dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                sum+=dp[i][j];
            }
        }
        // for(int i=0; i<n; i++) {
        //     for(int j = 0; j<m; j++) {
        //         System.out.print(dp[i][j]+",");
        //     }
        //     System.out.println("");
        // }
        return sum;
    }
}