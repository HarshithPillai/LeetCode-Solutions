class Solution {
    class Pair {
        int first, second;
        Pair(int f, int s) { first=f; second=s; }
    }
    public void dijkstra(List<List<Pair>> adj, int[] dist, int start) {
        dist[start]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,start)); // dis, node
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dis = top.first;
            int node = top.second;
            for(Pair nbr:adj.get(node)) {
                int next = nbr.first;
                int wt   = nbr.second;
                if(dist[next] > dis + wt) {
                    dist[next] = dis + wt;
                    pq.add(new Pair(dis + wt, next));
                }
            }
        }
    }
    public int findTheCity(int n, int[][] edges, int tar) {
        int m = edges.length;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0; i<m; i++) {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        int max=Integer.MAX_VALUE, res=-1;
        for(int i=0;i<n;i++) {
            int count=0;
            int[] dist = new int[n];
            Arrays.fill(dist,(int)(1e9));
            dijkstra(adj, dist, i);
            for(int j=0;j<n;j++) {
                if(dist[j]<=tar) {
                    count++;
                }
            }
            if(count<=max) {
                max=count;
                res=i;
            }
        }
        return res;
    }
}