class Solution {
    int n,m;
    public long maxPoints(int[][] points) {
        long res = 0;
        n = points.length;
        m = points[0].length;
        long[] curr = new long[m];
        for(int j=0; j<m; j++) {
            curr[j] = points[0][j];
        }
        for(int i=1; i<n; i++) {
            long[] left = new long[m];
            long[] right = new long[m];
            long[] prev = curr;
            curr = new long[m];
            left[0] = prev[0];
            right[m-1] = prev[m-1];
            for(int j=1; j<m; j++) {
                left[j] = Math.max(left[j-1]-1, prev[j]);
                // right[m-j-1] = Math.max(right[m-j]-1, prev[m-j-1]);
            }
            for(int j=m-2; j>=0; j--) {
                right[j] = Math.max(right[j+1]-1, prev[j]);
            }
            for(int j=0; j<m; j++) {
                curr[j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }
        for(int j=0; j<m; j++) res = Math.max(res, curr[j]);
        return res;
    }
}