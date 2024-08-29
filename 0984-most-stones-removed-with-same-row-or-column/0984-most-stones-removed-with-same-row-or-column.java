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
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int r = 0, c = 0;
        for(int[] stone:stones) {
            r = Math.max(r, stone[0]);
            c = Math.max(c, stone[1]);
        }
        r++;
        c++;
        DisjointSet ds = new DisjointSet(r+c);
        // find total parents with size more than 1, and subtract that number from 'n'
        for(int[] stone:stones) {
            ds.unionBySize(stone[0], stone[1]+r);
        }

        int ans=0;

        for(int i=0; i<r+c; i++) {
            if(ds.findUPar(i) == i && ds.size.get(i) > 1) {
                ans++;
            }
        }
        return n-ans;
    }
}