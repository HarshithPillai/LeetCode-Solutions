class Solution {
    int n, m, dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1};
    public void dfs(int[][] grid, int i, int j, int[][] vis) {
        vis[i][j] = 1;
        for(int k=0; k<4; k++) {
            int newr = i+dx[k], newc = j+dy[k];
            if(newr>=0 && newc>=0 && newr<n && newc<m && grid[newr][newc] == 1 && vis[newr][newc] == 0) {
                dfs(grid, newr, newc, vis);
            }
        }
    }
    public int countIslands(int[][] grid) {
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    dfs(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        count = countIslands(grid);
        if(count != 1) return 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}