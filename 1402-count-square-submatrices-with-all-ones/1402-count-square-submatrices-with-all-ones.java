class Solution {
    public int countSquares(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length, count=0;
        int dp[] = new int[c];
        for(int i=0; i<r; i++) {
            int dp1[] = new int[c];
            for(int j=0; j<c;j++) {
                if(matrix[i][j]==1) {
                    if(i==0 || j==0) dp1[j]=1;
                    else {
                        dp1[j] = 1 + Math.min(dp[j],Math.min(dp[j-1],dp1[j-1]));
                    }
                }
                count+=dp1[j];
            }
            dp=dp1;
        }
        return count;
    }
}