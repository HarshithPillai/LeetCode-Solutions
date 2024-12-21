class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] val, int k) {
        if(k==1) return n;
        if(n==1) return 1;
        long[] values = new long[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            values[i] = val[i];
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        int[] visited = new int[n];
        for(int[] ed:edges) {
            int u = ed[0], v = ed[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[v]++;
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(indegree[i] == 1) {
                q.add(i);
                visited[i]=1;
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            // visited[node] = 1;
            boolean found = (values[node] % k == 0);
            if(found) count++;
            
            for(int nbr:adj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr] == 1) {
                    q.add(nbr);
                }
                if(!found) values[nbr] += values[node];
            }
        }
        return count;
    }
}