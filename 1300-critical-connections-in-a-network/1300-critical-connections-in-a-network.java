class Solution {
    int timer = 1;
    public void dfs(List<List<Integer>> adj, int node, int parent, int[] t_in, int[] low, List<List<Integer>> res) {
        low[node]=timer;
        t_in[node]=timer;
        timer++;
        for(int nbr:adj.get(node)) {
            if(parent==nbr) continue;
            if(t_in[nbr]==0) {
                dfs(adj, nbr, node, t_in, low, res);
                low[node]=Math.min(low[node],low[nbr]);
                if(t_in[node] < low[nbr]) {
                    List<Integer> t=new ArrayList<>();
                    t.add(node);t.add(nbr);
                    res.add(t);
                }
            } else {
                low[node]=Math.min(low[node],low[nbr]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int t_in[] = new int[n];
        int  low[] = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(adj, 0, -1, t_in, low, res);
        return res;
    }
}