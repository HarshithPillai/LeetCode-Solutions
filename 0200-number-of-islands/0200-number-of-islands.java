class Solution {
    int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
    int n, m;
    int getIndex(int i, int j, int m) {
        return i*m + j;
    }
    public void dfs(char[][] grid, int i, int j, int[][] vis) {
        vis[i][j] = 1;
        for(int k=0; k<4; k++) {
            int newr = i+dx[k], newc = j+dy[k];
            if(newr<n && newc<m && newr>=0 && newc>=0 && grid[newr][newc] == '1' && vis[newr][newc] == 0) {
                dfs(grid, newr, newc, vis);
            }
        }
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        int[][] vis = new int[n][m];
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '0') continue;
                if(vis[i][j] == 0) {
                    ans++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return ans;
    }
}