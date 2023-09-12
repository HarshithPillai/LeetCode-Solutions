class Solution {
    int timer = 0;
    public void dfs(int[] t_in, int[] low, int[] vis, List<List<Integer>> adj, int node, int parent, List<List<Integer>> result) {
        vis[node]=1;
        t_in[node]=timer;
        low[node]=timer++;
        for(int nbr:adj.get(node)) {
            if(parent==nbr) continue;
            if(vis[nbr]==0) {
                dfs(t_in, low, vis, adj, nbr, node, result);
                low[node]=Math.min(low[node], low[nbr]);
                // check if this edge can be a critical bridge
                if(t_in[node]<low[nbr]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node); temp.add(nbr);
                    result.add(temp);
                }
            } else if(low[nbr]<low[node]) low[node]=low[nbr];
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] t_in = new int[n], low = new int[n], vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<connections.size();i++) {
            int u=connections.get(i).get(0), v=connections.get(i).get(1);
            adj.get(u).add(v); adj.get(v).add(u);
        }
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(t_in, low, vis, adj, 0, -1, result);
        return result;
    }
}