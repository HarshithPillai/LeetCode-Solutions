class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int count1 = 0, count0 = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    count1++;
                } else {
                    dist[i][j] = (int)1e9;
                    count0++;
                }
            }
        }
        if(count1==0 || count0==0) return -1;
        int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
        int distance = 1;
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] node = q.poll();
                int r = node[0], c = node[1];
                for(int k=0; k<4; k++) {
                    int newr = r+dx[k], newc = c+dy[k];
                    if(newr<n && newc<m && newr>=0 && newc>=0 && dist[newr][newc] > distance) {
                        dist[newr][newc] = distance;
                        res = Math.max(res, distance);
                        q.add(new int[]{newr, newc});
                    }
                }
            }
            distance++;
        }
        return res;
    }
}