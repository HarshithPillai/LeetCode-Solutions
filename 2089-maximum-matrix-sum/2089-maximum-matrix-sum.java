class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0, negCount = 0, n = matrix.length, absmin = (long)1e6;
        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] < 0) negCount++;
                int abs = Math.abs(matrix[i][j]);
                absmin = Math.min(abs, absmin);
                sum += abs;
            }
        }
        if(negCount % 2 == 0) return sum;
        return sum - 2*absmin;
    }
}