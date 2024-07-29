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
            int parU = findUPar(u), parV = findUPar(v);
            if(parU == parV) return false;
            int sizeU = size.get(parU), sizeV = size.get(parV);
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
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = n;
        DisjointSet ds = new DisjointSet(n*m);
        int[] dx = {1,0,-1,0}, dy= {0,-1,0,1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    int node = i*m+j;
                    for(int k=0; k<4; k++) {
                        int newr = i+dx[k], newc = j+dy[k];
                        if(newr<n && newr>=0 && newc<m && newc>=0 && grid[newr][newc] == 1) {
                            int nbr = newr*m + newc;
                            ds.unionBySize(nbr, node);
                        }
                    }
                }
            }
        }
        int max = 1, zero = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    zero++;
                    int node = i*m+j;
                    Set<Integer> pars = new HashSet<>();
                    for(int k=0; k<4; k++) {
                        int newr = i+dx[k], newc = j+dy[k];
                        if(newr<n && newr>=0 && newc<m && newc>=0 && grid[newr][newc] == 1) {
                            int nbr = newr*m + newc;
                            pars.add(ds.findUPar(nbr));
                        }
                    }
                    int count = 0;
                    for(int par:pars) count+=ds.size.get(par);
                    max = Math.max(count+1, max);
                }
            }
        }
        if(zero==0) return n*m;
        return max;
    }
}