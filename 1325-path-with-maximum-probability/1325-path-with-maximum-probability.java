class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int st, int en) {
        /**
            Jamun
        */
        
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));

        pq.add(new double[]{st, 1});
        List<List<double[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int ind=0;
        for(int[] ed:edges){
            int u=ed[0], v=ed[1];
            double w = succProb[ind];
            adj.get(u).add(new double[]{v, w});
            adj.get(v).add(new double[]{u, w});
            ind++;
        }
        double[] dist = new double[n];
        dist[st] = 1;
        while(!pq.isEmpty()) {
            double[] top = pq.poll();
            int node = (int) top[0];
            double distance = top[1];
            for(double[] next:adj.get(node)) {
                int nbr = (int) next[0];
                double w = next[1];
                if(dist[nbr] < distance*w) {
                    dist[nbr] = distance*w;
                    pq.add(new double[]{nbr, dist[nbr]});
                }
            }
        }
        return dist[en];
    }
}