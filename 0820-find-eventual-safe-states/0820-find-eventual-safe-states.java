class Solution {
    /* 
        approach: using Kahn's algo
        reveres all the edges of the graph and get all the new indegrees for each nodes
        and on each occurence of the node in the bfs traversal, just keep reducing their respective indegrees
        when a node's indegree drops to 0 add it to queue.
    */
    public boolean helper(int[][] graph, int[] vis, int[] check, int[] path, int node) {
        vis[node]=1;
        path[node]=1;
        for(int nbr:graph[node]) {
            if(vis[nbr]==0) {
                if(helper(graph, vis, check, path, nbr)) return true;
            } else if(path[nbr]==1) return true;
        }
        path[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] check = new int[n];
        int[] vis   = new int[n];
        int[] path  = new int[n];
        for(int i=0;i<n;i++)if(vis[i]==0)helper(graph, vis, check, path, i);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) if(check[i]==1) res.add(i);
        return res;
    }
}