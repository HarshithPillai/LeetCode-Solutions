// mohit jeet gya

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double dist[] = new double[n];
        Queue<double[]> q = new LinkedList<>();
        List<List<double[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int ind=0;
        for(int[] ed:edges) {
            int u = ed[0];
            int v = ed[1];
            double w = succProb[ind];
            ind++;
            adj.get(u).add(new double[]{v, w});
            adj.get(v).add(new double[]{u, w});
        }
        q.add(new double[]{start_node, 1});
        double[] ans = new double[n];
        dist[start_node] = 1;
        while(!q.isEmpty()) {
            double[] top = q.poll();
            int node = (int)top[0];
            double w = top[1];
            // if(node == end_node) return w;
            for(double[] next:adj.get(node)) {
                int nbr = (int)next[0];
                double weight = next[1];
                if(w*weight > dist[nbr]) {
                    dist[nbr] = w*weight;
                    q.add(new double[]{nbr, dist[nbr]});
                }
            }
        }
        return dist[end_node];
    }
}