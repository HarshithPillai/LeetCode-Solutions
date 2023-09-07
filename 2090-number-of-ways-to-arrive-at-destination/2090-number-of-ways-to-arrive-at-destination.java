class Solution {
    class Pair {
        long first, second;
        Pair(long f, long s) { first=f; second=s; }
    }
    public int countPaths(int n, int[][] roads) {
        long MOD=(long)(1e9+7);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> (int)(x.first-y.first));
        //Queue<Pair> pq = new LinkedList<>();
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long ways[] = new long[n];
        long dist[] = new long[n];
        for(int i=0;i<n;i++) dist[i]=Long.MAX_VALUE;
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));//dist, node
        while(!pq.isEmpty()) {
            Pair top=pq.poll();
            long dis = top.first;
            long node= top.second;
            for(Pair p:adj.get((int)node)) {
                long newNode=p.first;
                long newNodeWeight=p.second;
                long val=(dis+newNodeWeight);
                if(val < dist[(int)newNode]) {
                    ways[(int)newNode]=ways[(int)node];
                    dist[(int)newNode]=val;
                    pq.add(new Pair(val, newNode));
                } else if(val == dist[(int)newNode]) {
                    ways[(int)newNode]=(ways[(int)newNode]+ways[(int)node])%MOD;
                    //pq.add(new Pair((dis+newNodeWeight), newNode));
                }
            }
        }

        //if(dist[n-1]==(int)1e9) return -1;
        return (int)(ways[n-1]%MOD);
    }
}