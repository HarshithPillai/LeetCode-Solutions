class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int n=graph.length;
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n];
        
        for(int i=0; i<n; i++) revAdj.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            for(int num:graph[i]) {
                revAdj.get(num).add(i);
            }
        }

        for(int i=0; i<n; i++) {
            for(int num:revAdj.get(i)) {
                indegree[num]++;
            }
        }
        for(int i=0; i<n; i++) if(indegree[i]==0) q.add(i);

        while(!q.isEmpty()) {
            int node=q.poll();
            result.add(node);
            for(int num:revAdj.get(node)) {
                indegree[num]--;
                if(indegree[num]==0) q.add(num);
            }
        }
        Collections.sort(result);
        return result;
    }
}