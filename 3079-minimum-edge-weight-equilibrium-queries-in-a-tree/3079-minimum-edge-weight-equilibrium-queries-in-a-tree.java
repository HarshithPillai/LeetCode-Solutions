class Solution {
    int[][] weights, anc;
    int LOG = 15;
    int[] depth;
    public void populateWeights(List<List<int[]>> adj, int node, int parent, int[] freq) {
        anc[node][0] = parent;
        for(int[] next:adj.get(node)) {
            int v = next[0], w = next[1];
            if(parent == v) continue;
            freq[w]++;
            depth[v] = depth[node]+1;
            anc[v][0] = node;
            for(int i=0; i<27; i++) {
                weights[v][i] = freq[i];
                // if(i<LOG) anc[v][i] = anc[anc[v][i-1]][i-1];
            }
            for(int i=1; i<LOG; i++) {
                if(anc[v][i-1]>=0) anc[v][i] = anc[anc[v][i-1]][i-1];
            }
            populateWeights(adj, v, node, freq);
            freq[w]--;
        }
    }
    public int findLca(int a, int b) {
        if(depth[a] < depth[b]) return findLca(b, a);
        int k = depth[a] - depth[b];
        for(int j=0; j<=LOG; j++) {
            if(((1<<j) & k) != 0) {
                a = anc[a][j];
            }
        }
        if(a == b) return a;
        for(int j=LOG-1; j>=0; j--) {
            if(anc[a][j] != anc[b][j]) {
                a = anc[a][j];
                b = anc[b][j];
            }
        }
        
        return anc[a][0];
    }
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        // keep frequency of weights in the path from node 0 to each node
        weights = new int[n][27];
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] ed:edges) {
            int u = ed[0], v = ed[1], w = ed[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        depth = new int[n];
        anc = new int[n][16];
        populateWeights(adj, 0, -1, new int[27]);
        int m = queries.length;
        int ans[] = new int[m];
        for(int i=0; i<m; i++) {
            int a = queries[i][0], b = queries[i][1];
            int lca = findLca(a, b);
            int freq[] = new int[27];
            int maxFreq = -1, maxFreqWt = 0;
            for(int wt=0; wt<27; wt++) {
                freq[wt] = weights[a][wt] + weights[b][wt] - 2 * weights[lca][wt];
                if(freq[wt] > maxFreq) {
                    maxFreq = freq[wt];
                    maxFreqWt = wt;
                }
            }
            for(int wt=0; wt<27; wt++) {
                if(wt == maxFreqWt) continue;
                ans[i] += freq[wt];
            }
        }
        return ans;
    }
}