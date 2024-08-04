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
    public int numOfIslands(int[][] grid) {
        int count=0;
        int[][] vis = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        /**
            the only thing to realize here is 
            that the answer can ONLY be 0, 1 or 2
        */
        n = grid.length; m = grid[0].length;
        if(numOfIslands(grid) != 1) return 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int count = numOfIslands(grid);
                    if(count != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}