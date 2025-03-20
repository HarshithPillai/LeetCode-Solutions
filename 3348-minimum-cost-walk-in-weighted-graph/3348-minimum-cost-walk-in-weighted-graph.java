class Solution {
    public class DisjointSet {
        List<Integer> parent, size, cost;

        public DisjointSet(int n) {
            parent = new ArrayList();
            size = new ArrayList<>();
            cost = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
                cost.add(-1);
            }
        }

        public int findUPar(int node) {
            int par = parent.get(node);
            if (par != node) {
                par = findUPar(par);
                parent.set(node, par);
            }
            return par;
        }

        public boolean unionBySize(int u, int v, int w) {
            int uPar = findUPar(u), vPar = findUPar(v), sizeU = size.get(uPar), sizeV = size.get(vPar);
            parent.set(vPar, uPar);
            size.set(uPar, sizeU + sizeV);
            cost.set(uPar, cost.get(uPar) & cost.get(vPar) & w);
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
                ans[i] = ds.cost.get(uPar);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}