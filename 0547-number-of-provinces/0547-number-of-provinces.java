class Solution {
    class DisjointSet {
        List<Integer> parent, size;
        public DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i=0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }
        public int findUPar(int node) {
            int par = parent.get(node);
            if(par != node) {
                par = findUPar(par);
                parent.set(node, par);
            }
            return par;
        }
        public boolean unionBySize(int u, int v) {
            int parU = findUPar(u), parV = findUPar(v), sizeU = size.get(parU), sizeV = size.get(parV);
            if(parU == parV) return false;
            if(sizeU < sizeV) {
                parent.set(parU, parV);
                size.set(parV, sizeU + sizeV);
            } else {
                parent.set(parV, parU);
                size.set(parU, sizeU + sizeV);
            }
            return true;
        }
    }
    public int findCircleNum(int[][] edges) {
        int n = edges.length, ans = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(edges[i][j] == 1) ds.unionBySize(i, j);
            }
        }
        for(int i = 0; i<n; i++) if(ds.parent.get(i) == i) ans++;
        return ans;
    }
}