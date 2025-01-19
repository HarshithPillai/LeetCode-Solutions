class Solution {
    public int trapRainWater(int[][] arr) {
        int n = arr.length, m = arr[0].length, ans = 0;
        int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
        int[][] vis = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int i=0; i<n; i++) {
            pq.add(new int[]{arr[i][0], i, 0});
            vis[i][0] = 1;
            pq.add(new int[]{arr[i][m-1], i, m-1});
            vis[i][m-1] = 1;
        }
        for(int j=1; j<m-1; j++) {
            pq.add(new int[]{arr[0][j], 0, j});
            vis[0][j] = 1;
            pq.add(new int[]{arr[n-1][j], n-1, j});
            vis[n-1][j] = 1;
        }
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int val = top[0], r = top[1], c = top[2];
            for(int k = 0; k<4; k++) {
                int newr = dx[k] + r, newc = dy[k] + c;
                if(newr < n && newc < m && newc >= 0 && newr >= 0 && vis[newr][newc] == 0) {
                    vis[newr][newc] = 1;
                    if(arr[newr][newc] < val) {
                        ans += val - arr[newr][newc];
                        pq.add(new int[]{val, newr, newc});
                    } else {
                        pq.add(new int[]{arr[newr][newc], newr, newc});
                    }
                }
            }
        }
        return ans;
    }
}