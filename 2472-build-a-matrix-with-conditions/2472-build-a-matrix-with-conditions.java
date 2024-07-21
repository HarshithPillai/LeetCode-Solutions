class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k];
        /**
            edges are given
            topo sort both graphs
            get the topo sorted row from row graph and column from column graph
            how? loop over each and store in a map<Integer, int[]>
            [node, {i,j}]
            if count of nodes in bfs != k return empty matrix
            else populate the matrix according to the hashmap
        */
        List<List<Integer>> rowadj = new ArrayList<>();
        List<List<Integer>> coladj = new ArrayList<>();
        for(int i=0; i<=k; i++) {
            rowadj.add(new ArrayList<>());
            coladj.add(new ArrayList<>());
        }
        int[] rowindegree = new int[k+1];
        int[] colindegree = new int[k+1];
        for(int[] edge:rowConditions) {
            int u = edge[0], v = edge[1];
            rowadj.get(u).add(v);
            rowindegree[v]++;
        }
        for(int[] edge:colConditions) {
            int u = edge[0], v = edge[1];
            coladj.get(u).add(v);
            colindegree[v]++;
        }
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        for(int i=1; i<=k; i++) {
            if(rowindegree[i] == 0) qr.add(i);
            if(colindegree[i] == 0) qc.add(i);
        }
        int ind = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(!qr.isEmpty()) {
            int node = qr.poll();
            count++;
            map.put(node, ind);
            ind++;
            for(int nbr:rowadj.get(node)) {
                rowindegree[nbr]--;
                if(rowindegree[nbr] == 0) {
                    qr.add(nbr);
                }
            }
        }
        if(count<k) return new int[0][0];
        ind=0;
        count = 0;
        while(!qc.isEmpty()) {
            int node = qc.poll();
            ans[map.get(node)][ind] = node;
            ind++;count++;
            for(int nbr:coladj.get(node)) {
                colindegree[nbr]--;
                if(colindegree[nbr] == 0) {
                    qc.add(nbr);
                }
            }
        }
        if(count<k) return new int[0][0];
        return ans;
    }
}