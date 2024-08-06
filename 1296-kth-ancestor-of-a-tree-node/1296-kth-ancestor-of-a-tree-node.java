class TreeAncestor {
    int[][] up;
    int log = 1;
    int depth[];
    List<Integer> order = new ArrayList<>();
    public TreeAncestor(int n, int[] parent) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList());
        for(int i=0; i<parent.length; i++) {
            int u = parent[i], v = i;
            if(u == -1) continue;
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int nd = q.poll();
            order.add(nd);
            for(int nbr:adj.get(nd)) {
                q.add(nbr);
            }
        }
        log=1;
        while((1<<log) <= n) log++;
        up = new int[n][log];
        depth = new int[n];
        parent[0] = 0;
        for(int v:order) {
            up[v][0] = parent[v];
            if(v!=0) depth[v] = depth[parent[v]] + 1;
            for(int j=1; j<log; j++) {
                up[v][j] = up[ up[v][j-1] ][j-1];
                // System.out.print(up[v][j]+" ");
            }
            // System.out.println("");
        }
    }
    
    public int getKthAncestor(int node, int k) {
        /**
            loop power from 0 till bitmask<=k:
                take a bitmask = 1<<power
                if bitmask & k == 1:
                    go to that power parent -> currNode's Math.pow(2,power) parent
                    currNode = anc[curr][power]
        */
        // System.out.println(node+" ---- "+ k + " " + log);
        if(depth[node] < k) return -1;
        for(int j=log; j>=0; j--) {
            if(((1<<j) & k) > 0) {
                // System.out.println(node+" "+j);
                node = up[node][j];
                // System.out.println(node+" "+j);
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */