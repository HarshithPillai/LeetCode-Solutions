class Solution {
    public class DisjointSet {
        List<Integer> parent, size;
        int count = 0;
        public DisjointSet(int n) {
            parent = new ArrayList<>();
            size = new ArrayList<>();
            count = n;
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
                size.set(parV, sizeU+sizeV);
            } else {
                parent.set(parV, parU);
                size.set(parU, sizeU+sizeV);
            }
            count--;
            return true;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int total = 0, ind = 0, m = edges.length;
        int[][] ed = new int[edges.length][4];
        for(int[] edge:edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            ed[ind][0] = u;
            ed[ind][1] = v;
            ed[ind][2] = w;
            ed[ind][3] = ind;
            ind++;
        }
        Arrays.sort(ed, (a, b)->Integer.compare(a[2], b[2]));
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for(int[] edge:ed) {
            // System.out.println(edge[0]+" "+edge[1]+" "+edge[2]+" "+edge[3]);
            if(ds.unionBySize(edge[0], edge[1])) total += edge[2];
        }
        for(int disabled = 0; disabled < m; disabled++) {
            DisjointSet tempds = new DisjointSet(n);
            int newtotal = 0;
            for(int[] edge:ed) {
                if(edge[3] == disabled) {
                    continue;
                }
                if(tempds.unionBySize(edge[0], edge[1])) newtotal += edge[2];
            }
            // System.out.println(newtotal+" "+total);
            if(tempds.count!=1 || newtotal > total) {
                ans.get(0).add(disabled);
            } else {
                DisjointSet pseudods = new DisjointSet(n);
                int pseudototal = edges[disabled][2];
                pseudods.unionBySize(edges[disabled][0], edges[disabled][1]);
                for(int[] edge:ed) {
                    if(pseudods.unionBySize(edge[0], edge[1])) pseudototal += edge[2];
                }
                if(pseudototal == total) ans.get(1).add(disabled);
            }
        }
        return ans;
    }
}