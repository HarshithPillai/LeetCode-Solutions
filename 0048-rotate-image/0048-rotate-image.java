class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int temp=matrix[0][0];
        // 1. transpose 
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int a=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=a;
            }
        }
        //2. reverse
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int a=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=a;
            }
        }
    }
}