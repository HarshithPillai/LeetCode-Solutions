class Solution {
    public void helper(List<List<Integer>> adj, int[] vis, int node, List<Integer> comp) {
        comp.add(node);
        for (int nbr : adj.get(node)) {
            if (vis[nbr] == 0) {
                vis[nbr] = 1;
                helper(adj, vis, nbr, comp);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] ed : edges) {
            int u = ed[0], v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                List<Integer> component = new ArrayList<>();
                boolean flag = true;
                vis[i] = 1;
                helper(adj, vis, i, component);
                int size = component.size();
                for (int node : component) {
                    if (adj.get(node).size() != size - 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
        }
        return ans;
    }
}