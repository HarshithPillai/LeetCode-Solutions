class Solution {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>(), size = new ArrayList<>();
        DisjointSet(int n) {
            for(int i=0;i<n;i++) {
                parent.add(i); size.add(1);
            }
        }
        public int findUPar(int u) {
            if(parent.get(u)==u) return u;
            int ulp = findUPar(parent.get(u));
            parent.set(u, ulp);
            return ulp;
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
    public int removeStones(int[][] stones) {
        int m = stones.length, count=0;
        int rows=0, cols=0;
        for(int i=0;i<m;i++) {
            rows=Math.max(rows,stones[i][0]);
            cols=Math.max(cols,stones[i][1]);
        }
        rows++; cols++;
        DisjointSet ds = new DisjointSet(rows+cols);
        
        for(int i=0;i<m;i++) {
            count++;
            ds.unionBySize(stones[i][0], stones[i][1]+rows);
        }

        int components = 0;
        for(int i=0;i<rows+cols;i++) {
            if(ds.findUPar(i)==i && ds.size.get(i)>1) {
                components++;
            }
        }
        return count-components;
    }
}