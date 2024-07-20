class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int indegree[] = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n; i++) adj.add(new ArrayList<>());
        for(int edge[]:prerequisites) {
            int u = edge[1], v = edge[0];
            indegree[v]++;
            adj.get(u).add(v);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n; i++) {
            if(indegree[i] == 0) {
                count++;
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int nbr:adj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                    count++;
                }
            }
        }
        return count == n;
    }
}