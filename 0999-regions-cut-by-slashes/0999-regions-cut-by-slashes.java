class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    public void dfs(int[][] arr, int i, int j, int n, int m) {
        arr[i][j] = 1;
        for(int k=0; k<4; k++) {
            int newr = i+dx[k], newc = j+dy[k];
            if(newr<n && newr>=0 && newc>=0 && newc<m && arr[newr][newc] == 0) {
                dfs(arr, newr, newc, n, m);
            }
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int[][] arr = new int[n*3][m*3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char ch = grid[i].charAt(j);
                if(ch!=' ') {
                    int row = i*3+1, col = j*3+1;
                    arr[row][col] = 1;
                    if(ch == '/') {
                        arr[row-1][col+1] = 1;
                        arr[row+1][col-1] = 1;
                    } else {
                        arr[row-1][col-1] = 1;
                        arr[row+1][col+1] = 1;
                    }
                }
            }
        }
        int count = 0;
        for(int i=0; i<3*n; i++) {
            for(int j=0; j<3*m; j++) {
                if(arr[i][j] == 0) {
                    count++;
                    dfs(arr, i, j, 3*n, 3*m);
                }
            }
        }
        return count;
    }
}