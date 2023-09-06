class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        // similar to detecting cylcle in a directed graph
        // using Kahn's algorithm
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i=0; i<prerequisites.length; i++) {
            int x = prerequisites[i][1];
            int y = prerequisites[i][0];
            adj.get(x).add(y);
            indegree[y]++;
        }
        int count=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }
        int[] ans = new int[n];
        while(!q.isEmpty()) {
            int node=q.poll();
            ans[count++]=node;
            for(int num:adj.get(node)) {
                indegree[num]--;
                if(indegree[num]==0) {
                    q.add(num);
                }
            }
        }
        if(count!=n) return new int[0];
        return ans;
    }
}