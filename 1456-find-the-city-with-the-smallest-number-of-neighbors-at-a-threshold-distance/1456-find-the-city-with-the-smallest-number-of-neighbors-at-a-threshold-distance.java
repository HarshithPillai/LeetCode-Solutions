class Solution {
    int thr;
    public int bfs(List<List<int[]>> adj, int src, int n) {
        int dist[] = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        int count = 0;
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int node = top[0];
            int dis = top[1];
            for(int[] next:adj.get(node)) {
                int nbr = next[0], distance = next[1];
                if(distance+dis < dist[nbr]) {
                    dist[nbr] = distance+dis;
                    q.add(new int[]{nbr, distance+dis});
                }
            }
        }
        for(int i=0; i<n; i++) {
            if(i==src) continue;
            if(dist[i]<=thr) count++;
        }
        return count;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        thr = distanceThreshold;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] ed:edges) {
            int u = ed[0], v = ed[1], w = ed[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        int ans = 0, minYet = (int)1e9;
        for(int i=0; i<n; i++) {
            int val = bfs(adj, i, n);
            if(val <= minYet) {
                minYet = val;
                ans = i;
            }
        }
        return ans;
    }
}