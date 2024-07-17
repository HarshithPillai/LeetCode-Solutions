class Solution {
    int ans = 0, curr = 0;
    Set<Integer> set;
    int[] vis;
    boolean valid = true;
    public void dfs(List<List<Integer>> adj, int node) {
        vis[node] = 1;
        for(int nbr:adj.get(node)) {
            if(vis[nbr] == 0) {
                if(!set.contains(node)) valid = false;
                dfs(adj, nbr);
            }
        }
        if(adj.get(node).size() != curr || !set.contains(node)) valid = false;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        vis = new int[n];
        for(int i=0; i<n; i++) {
            // for(int nbr:adj.get(i)) {
            //     System.out.print(nbr + " ");
            // }
            // System.out.println("");
            if(vis[i] == 0) {
                curr = adj.get(i).size();
                set = new HashSet<>(adj.get(i));
                set.add(i);
                dfs(adj, i);
                if(valid) ans++;
                valid = true;
            }
        }
        return ans;
    }
}