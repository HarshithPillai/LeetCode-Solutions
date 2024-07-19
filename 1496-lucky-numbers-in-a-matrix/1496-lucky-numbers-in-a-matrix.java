class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        for(int i=0; i<n; i++) {
            int ind = 0, minyet = matrix[i][0];
            for(int j=1; j<m; j++) {
                if(matrix[i][j] < minyet) {
                    minyet = matrix[i][j];
                    ind = j;
                }
            }
            int maxind = i, maxyet = matrix[i][ind], flag = 0;
            for(int row = 0; row<n; row++) {
                if(matrix[row][ind] > maxyet) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) ans.add(minyet);
        }
        return ans;
    }
}