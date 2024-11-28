class Solution {
    int n = 0, m = 0, dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1};
    public int dfs(int[][] grid, int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int r = top[1], c = top[2];
            if(r == n-1 && c == m-1) return top[0];
            for(int k=0; k<4; k++) {
                int newr = r + dx[k], newc = c + dy[k];
                if(newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    if(arr[newr][newc] > grid[newr][newc] + top[0]) {
                        arr[newr][newc] = grid[newr][newc] + top[0];
                        pq.add(new int[]{top[0]+grid[newr][newc], newr, newc});
                    }
                }
            }
        }
        return arr[n-1][m-1];
    }
    public int minimumObstacles(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] arr = new int[n][m];
        for(int[] k:arr) Arrays.fill(k, (int)1e6);
        arr[0][0] = 0;
        return dfs(grid, arr);
    }
}