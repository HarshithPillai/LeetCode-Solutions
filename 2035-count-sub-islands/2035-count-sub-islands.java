class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    int n,m;
    public boolean dfs(int[][] a, int[][] b, int i, int j, int[][] vis) {
        boolean isValid = a[i][j]==1;
        vis[i][j] = 1;
        for(int k=0; k<4; k++) {
            int newr = i+dx[k], newc = j+dy[k];
            if(newr<n && newc<m && newr>=0 && newc>=0 && b[newr][newc]==1 && vis[newr][newc] == 0) {
                isValid &= dfs(a,b,newr,newc,vis);
            }
        }
        return isValid;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length;
        m = grid1[0].length;
        int vis[][] = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid2[i][j] == 1 && vis[i][j] == 0) {
                    if(dfs(grid1, grid2, i, j, vis)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}