class Solution {
    public class DisjointSet {
        int[] parent, size, cost;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            cost = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
            int uPar = findUPar(u), vPar = findUPar(v), sizeU = size[uPar], sizeV = size[vPar];
            parent[vPar] = uPar;
            size[uPar] = sizeU + sizeV;
            cost[uPar] = cost[uPar] & cost[vPar] & w;
            return true;
        }
    }
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DisjointSet ds = new DisjointSet(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            ds.unionBySize(u, v, w);
        }
        int m = query.length, ans[] = new int[m];
        for (int i = 0; i < m; i++) {
            int u = query[i][0], v = query[i][1], uPar = ds.findUPar(u), vPar = ds.findUPar(v);
            if (uPar == vPar) {
                ans[i] = ds.cost[uPar];
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}