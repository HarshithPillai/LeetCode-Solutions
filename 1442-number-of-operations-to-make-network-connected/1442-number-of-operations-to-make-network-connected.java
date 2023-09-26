class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size   = new ArrayList<>();
        DisjointSet(int n) {
            for(int i=0;i<n;i++) {
                parent.add(i); size.add(1);
            }
        }
        public int findUPar(int u) {
            if(parent.get(u)==u) return u;
            int ulp_u = findUPar(parent.get(u));
            parent.set(u, ulp_u);
            return ulp_u;
        }
        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) > size.get(ulp_v)) {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            } else {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int m = connections.length;
        int extraEdges = 0; int components = 0;
        for(int i=0;i<m;i++) {
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u,v);
            } else {
                extraEdges++;
            }
        }
        int count_components = 0;
        for(int i=0;i<n;i++) {
            if(ds.parent.get(i)==i) count_components++;
        }
        if(count_components-1 > extraEdges) return -1;
        return count_components - 1;
    }
}