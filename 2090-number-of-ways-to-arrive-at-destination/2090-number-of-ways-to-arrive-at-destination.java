class Solution {
    class Pair {
        long first, second;
        Pair(long f, long s) { first=f; second=s; }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long MOD = (long)(1e9+7);
        long ways[] = new long[n];
        ways[0]=1;
        long dist[] = new long[n];
        for(int i=0;i<n;i++) {
            dist[i]=(long)1e18;
        }
        dist[0]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> (int)(x.first-y.first));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            long dis = top.first;
            int node = (int)top.second;
            for(Pair nbr:adj.get(node)) {
                int newNode=(int)nbr.first;
                long newWeight=nbr.second;
                long val=dis+newWeight;
                if(val < dist[newNode]) {
                    dist[newNode] = val;
                    ways[newNode] = ways[node];
                    pq.add(new Pair(val, newNode));
                } else if(val == dist[newNode]) {
                    ways[newNode] = (ways[newNode]+ways[node])%MOD;
                    //pq.add(new Pair(val, newNode));
                }
            }
        }
        return (int)(ways[n-1]%MOD);
    }
}