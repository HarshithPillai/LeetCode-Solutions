class Solution {
    public class DisjointSet {
        int[] parent, cost;

        public DisjointSet(int n) {
            parent = new int[n];
            cost = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                cost[i] = -1;
            }
        }

        public int findUPar(int node) {
            int par = parent[node];
            if (par != node) {
                par = findUPar(par);
                parent[node] = par;
            }
            return par;
        }

        public boolean unionBySize(int u, int v, int w) {
            int uPar = findUPar(u), vPar = findUPar(v);
            parent[vPar] = uPar;
            cost[uPar] = cost[uPar] & cost[vPar] & w;
            return true;
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        int m = query.length, ans[] = new int[m];
        for (int[] edge : edges) ds.unionBySize(edge[0], edge[1], edge[2]);
        for (int i = 0; i < m; i++) {
            int uPar = ds.findUPar(query[i][0]), vPar = ds.findUPar(query[i][1]);
            ans[i] = (uPar == vPar) ? ds.cost[uPar] : -1;
        }
        return ans;
    }
}