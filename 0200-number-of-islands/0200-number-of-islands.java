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
    int getIndex(int i, int j, int m) {
        return i*m + j;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet ds = new DisjointSet(m*n);
        int[] dx = {1,0,-1,0}, dy = {0,-1,0,1};
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '0') continue;
                for(int k=0; k<4; k++) {
                    int newr = i+dx[k], newc = j+dy[k];
                    if(newr<n && newc<m && newr>=0 && newc>=0 && grid[newr][newc] == '1') {
                        ds.unionBySize(getIndex(i, j, m), getIndex(newr, newc, m));
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '0') continue;
                int ind = getIndex(i, j, m);
                if(ds.parent.get(ind) == ind) ans++;
            }
        }
        return ans;
    }
}