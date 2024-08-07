class Solution {
    /**
        Pre-requisites:
            1. Binary lifting
            2. Kth Ancestor
            3. LCA using binary lifting
    */
    int[][] weights, up;
    int log = 15;
    int[] depth;
    public void dfs(List<List<int[]>> adj, int node, int parent, int dep) {
        depth[node] = dep;
        up[node][0] = parent;
        for(int[] next:adj.get(node)) {
            int v = next[0];
            if(v == parent) continue;
            up[v][0] = node;
            for(int l = 1; l<log; l++) {
                up[v][l] = up[up[v][l-1]][l-1];
            }
            dfs(adj, v, node, dep+1);
        }
    }
    public void populateWeights(List<List<int[]>> adj, int node, int[] freq, int parent) {
        for(int[] next:adj.get(node)) {
            int v = next[0], w = next[1];
            if(v == parent) continue;
            freq[w]++;
            for(int i=1; i<27; i++) {
                weights[v][i] = freq[i];
            }
            populateWeights(adj, v, freq, node);
            freq[w]--;
        }
    }
    public int findLca(int a, int b) {
        if(depth[a] < depth[b]) return findLca(b, a);
        int k = depth[a] - depth[b];
        for(int j=0; j<=log; j++) {
            if(((1<<j) & k) != 0) {
                a = up[a][j];
            }
        }
        if(a == b) return a;
        for(int j=log-1; j>=0; j--) {
            if(up[a][j] != up[b][j]) {
                a = up[a][j];
                b = up[b][j];
            }
        }
        
        return up[a][0];
    }
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        weights = new int[n][27];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int ed[]:edges) {
            int u = ed[0], v = ed[1], w = ed[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
        // taking 0 as root and calculating the total weights for all nodes from root
        populateWeights(adj, 0, new int[27], -1);
        up = new int[n][log+1];
        depth = new int[n];
        dfs(adj, 0, 0, 0);
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int lca = findLca(a, b);
            // System.out.println(a + " " + b + " " + lca);
            int[] freq = new int[27];
            int max = 0, maxFreqEdgeWt=-1;
            for(int j=1; j<27; j++) {
                freq[j] = weights[a][j] + weights[b][j] - 2*(weights[lca][j]);
                if(max<freq[j]) {
                    max = freq[j];
                    maxFreqEdgeWt = j;
                }
            }
            for(int j=1; j<27; j++) {
                if(j==maxFreqEdgeWt) continue;
                ans[i] += freq[j];
            }
        }
        return ans;
    }
}