class Solution {
    public void djikstra(long[] dist, int n, List<List<int[]>> adj, int src) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            int node = top[0], wt = top[1];
            for(int[] next:adj.get(node)) {
                int nbr = next[0], newDist = next[1];
                if(dist[nbr] > wt+newDist) {
                    dist[nbr] = wt+newDist;
                    q.add(new int[]{nbr, (int)dist[nbr]});
                }
            }
        }
    }
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if(w == -1) continue;
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        long dist[] = new long[n];
        Arrays.fill(dist, (long)1e18);
        dist[source] = 0;
        djikstra(dist, n, adj, source);
        if(dist[destination] < target) {
            // Even without the negative edges, the shortest path is below TARGET
            return new int[0][0];
        }

        if(dist[destination] == target) {
            for(int i=0; i<edges.length; i++) {
                if(edges[i][2] == -1) edges[i][2] = (int)1e9;
            }
            return edges;
        }
        

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            if(w == -1) {
                edges[i][2] = w = 1;
                adj.get(u).add(new int[]{v,w});
                adj.get(v).add(new int[]{u,w});
                long distance[] = new long[n];
                Arrays.fill(distance, (long)1e18);
                distance[source] = 0;
                djikstra(distance, n, adj, source);
                if(distance[destination] <= target) {
                    edges[i][2] += target - distance[destination];
                    for(int j=i+1; j<edges.length; j++) {
                        if(edges[j][2] == -1) edges[j][2] = (int)1e9;
                    }
                    return edges;
                }
            }
        }
        return new int[0][0];
    }
}