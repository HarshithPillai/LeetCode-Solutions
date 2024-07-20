class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        /**
            store rowSum to the first column as is
            go over each column
            take the sum and then go over it again
            shift as much as you can to the next column
        */
        int n = rowSum.length, m = colSum.length, ans[][] = new int[n][m];
        long currCol = 0;
        for(int i=0; i<n; i++) {
            ans[i][0] = rowSum[i];
            currCol+=rowSum[i];
        }
        for(int j=0; j<m-1; j++) {
            long nextCol = 0;
            for(int i=0; i<n; i++) {
                long diff = currCol - colSum[j];
                long rem = Math.min(diff, ans[i][j]);
                currCol -= rem;
                ans[i][j] -= (int)rem;
                nextCol += rem;
                ans[i][j+1] = (int)rem;
            }
            currCol = nextCol;
        }
        return ans;
    }
}