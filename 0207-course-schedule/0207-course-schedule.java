class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i=0; i<prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            adj.get(x).add(y);
            indegree[y]++;
        }
        int count=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node=q.poll();
            count++;
            for(int num:adj.get(node)) {
                indegree[num]--;
                if(indegree[num]==0) {
                    q.add(num);
                }
            }
        }
        return (count==n);
    }
}