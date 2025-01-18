class Solution {
    int n, m;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean isvalid(int i, int j) {
        return (i<n && j<m && i>=0 && j>=0);
    }
    public int helper(int[][] grid, int[][] cost) {
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,0}); // cost, i, j

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int dist = top[0], r = top[1], c = top[2];
            if(r == n-1 && c == m-1) return dist;
            for(int k=0; k<4; k++) {
                int newr = r + dir[k][0], newc = c + dir[k][1];
                if(!isvalid(newr, newc)) continue;
                if(k+1 == grid[r][c] && cost[newr][newc] > dist) {
                    pq.add(new int[]{dist, newr, newc});
                    cost[newr][newc] = dist;
                } else if(k+1 != grid[r][c] && cost[newr][newc] > dist+1) {
                    pq.add(new int[]{dist+1, newr, newc});
                    cost[newr][newc] = dist+1;
                }
            }
        }
        return cost[n-1][m-1];
    }
    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] cost = new int[n][m];
        for(int[] arr:cost) Arrays.fill(arr, (int)1e7);
        return helper(grid, cost);
    }
}