class Solution {
    /* 
        approach: using Kahn's algo
        reveres all the edges of the graph and get all the new indegrees for each nodes
        and on each occurence of the node in the bfs traversal, just keep reducing their respective indegrees
        when a node's indegree drops to 0 add it to queue.
    */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        int n=graph.length;
        int[] indegree = new int[n];
        for(int i=0;i<n;i++) revAdj.add(new ArrayList<>());
        for(int i=0;i<n;i++) {
            for(int j=0;j<graph[i].length;j++) {
                revAdj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.add(i);
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for(int nbr:revAdj.get(node)) {
                indegree[nbr]--;
                if(indegree[nbr]==0) {
                    q.add(nbr);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}