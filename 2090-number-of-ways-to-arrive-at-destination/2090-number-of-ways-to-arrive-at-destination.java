class Solution {
    public int countPaths(int n, int[][] roads) {
        /**
            create adj list
        */
        int MOD = (int)1e9 + 7;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] ed:roads) {
            int u = ed[0], v = ed[1], w = ed[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        long[] dis = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dis, (long)1e18);

        dis[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)->Long.compare(a[1], b[1]));
        q.add(new long[]{0, 0});
        while(!q.isEmpty()) {
            long[] front = q.poll();
            int node = (int)front[0];
            long w = front[1];
            for(int next[]:adj.get(node)) {
                int nbr = next[0];
                long dist = next[1];
                long sum = (w+dist);
                if(dis[nbr] == sum) {
                    ways[nbr] = (ways[nbr] + ways[node])%MOD;
                } else if(dis[nbr] > sum) {
                    dis[nbr] = sum;
                    ways[nbr] = ways[node];
                    q.add(new long[]{nbr, sum});
                }
            }
        }
        return (int)ways[n-1];
    }
}