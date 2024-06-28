class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge:times) {
            int u = edge[0]-1, v = edge[1]-1, w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e6);
        dist[k-1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.add(new int[]{k-1, 0});
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int dis = top[1];
            for(int[] nbr:adj.get(node)) {
                int next = nbr[0], newDist = nbr[1];
                if(dist[next] > dis+newDist) {
                    dist[next] = dis+newDist;
                    pq.add(new int[]{next, dis+newDist});
                }
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(dist[i] == (int)1e6) return -1;
            sum=Math.max(dist[i], sum);
        }
        return sum;
    }
}