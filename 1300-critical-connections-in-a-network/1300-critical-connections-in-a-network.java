class Solution {
    int[] t_in, low;
    int timer = 1;
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(List<List<Integer>> adj, int node, int parent) {
        t_in[node] = timer;
        low[node] = timer;
        timer++;
        for(int nbr:adj.get(node)) {
            if(nbr != parent) {
                if(t_in[nbr] != 0) {
                    low[node] = Math.min(low[nbr], low[node]);
                } else {
                    dfs(adj, nbr, node);
                    low[node] = Math.min(low[nbr], low[node]);
                    if(low[nbr] > t_in[node]) {
                        res.add(List.of(node, nbr));
                    }
                }
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        t_in = new int[n];
        low = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        for(List<Integer> edge:connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(adj, 0, -1);
        return res;
    }
}