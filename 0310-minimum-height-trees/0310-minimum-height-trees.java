class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n==0) return ans;
        if(n==1) {
            ans.add(0);
            return ans;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int edge[]:edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int left = n;
        for(int i=0; i<n; i++) {
            if(indegree[i] == 1) {
                q.add(i);
                indegree[i]=0;
                // left--;
            }
        }
        while(!q.isEmpty()) {
            if(left<3) {
                while(!q.isEmpty()) {
                    ans.add(q.poll());
                }
                break;
            }
            int size = q.size();
            for(int i=0; i<size; i++) {
                int node = q.poll();
                left--;
                for(int nbr:adj.get(node)) {
                    indegree[nbr]--;
                    if(indegree[nbr]==1) {
                        indegree[nbr] = 0;
                        q.add(nbr);
                    }
                }
            }
        }
        return ans;
    }
}