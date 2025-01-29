class Solution {
    class DisjointSet {
        List<Integer> parent, size;
        
        DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();

            for(int i=0; i<n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            int par = parent.get(node);
            if(par == node) return node;
            par = findUPar(par);
            parent.set(node, par);
            return par;
        }

        public boolean unionBySize(int u, int v) {
            int parU = findUPar(u), parV = findUPar(v), sizeU = size.get(parU), sizeV = size.get(parV);

            if(parU == parV) return false;
            if(sizeU > sizeV) {
                parent.set(parV, parU);
                size.set(parU, sizeU + sizeV);
            } else {
                parent.set(parU, parV);
                size.set(parV, sizeU + sizeV);
            }
            
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int max = 0;
        for(int[] ed: edges) {
            max = Math.max(ed[0], Math.max(ed[1], max));
        }
        int n = max + 1;
        int[] ans = new int[]{-1, -1};
        DisjointSet ds = new DisjointSet(n);
        for(int[] ed: edges) {
            int u = ed[0], v = ed[1];
            if(!ds.unionBySize(u, v)) {
                ans = ed;
            }
        }
        return ans;        
    }
}