class Solution {
    public class DisjointSet {
        List<Integer> parent, size;
        DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for(int i=0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }
        int findUPar(int node) {
            int par = parent.get(node);
            if(par != node) {
                par = findUPar(par);
                parent.set(node, par);
            }
            return par;
        }
        boolean unionBySize(int u, int v) {
            int parU = findUPar(u), parV = findUPar(v), sizeU = size.get(parU), sizeV = size.get(parV);
            if(parU == parV) return false;
            if(sizeU >= sizeV) {
                parent.set(parV, parU);
                size.set(parU, sizeU+sizeV);
            } else {
                parent.set(parU, parV);
                size.set(parV, sizeU+sizeV);
            }
            return true;
        }
    }
    public int removeStones(int[][] grid) {
        int n = 0, m = 0;
        for(int i[]:grid) {
            n = Math.max(i[0], n);
            m = Math.max(i[1], m);
        }
        n++; m++;
        DisjointSet ds = new DisjointSet(n+m);
        for(int[] coord:grid) {
            int u = coord[0], v = coord[1] + n;
            ds.unionBySize(u, v);
        }
        int count = grid.length, components = 0;
        for(int i=0;i<n+m; i++) {
            int par = ds.findUPar(i), sz = ds.size.get(par);
            if(par == i && sz>1) components++;
        }
        return count - components;
    }
}