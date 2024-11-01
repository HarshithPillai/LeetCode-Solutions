class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int edge[]:flights) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        k++;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while(!q.isEmpty()) {
            if(k==0) break;
            int size = q.size();
            for(int i=1; i<=size; i++) {
                int top[] = q.poll();
                int node = top[0];
                int wt = top[1];
                // if(node == dst) return wt;
                for(int[] next:adj.get(node)) {
                    if(dist[next[0]] > wt+next[1] ) {
                        dist[next[0]] = wt+next[1];
                        q.add(new int[]{next[0], wt+next[1]});
                    }
                }
            }
            k--;
        }
        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];
    }
}