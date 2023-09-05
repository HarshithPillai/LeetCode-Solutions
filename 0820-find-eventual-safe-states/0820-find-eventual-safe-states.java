class Solution {
    public boolean helper(int[][] graph, int node, int[] path, int[] visited, int[] check) {
        path[node]=1;
        visited[node]=1;
        for(int num:graph[node]) {
            if(visited[num]==0) {
                if(helper(graph, num, path, visited, check)) {
                    return true;
                }
            } else if(path[num]==1) return true;
        }

        // This marks this node as safe node as all the paths 
        // from this node have been checked for cycles and returned false
        check[node]=1; 
        path[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> result = new ArrayList<>();
        int[] path = new int[n];
        int[] check = new int[n];
        int[] visited = new int[n];
        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                helper(graph, i, path, visited, check);
            }
        }
        for(int i=0;i<n;i++) {
            if(check[i]==1) result.add(i);
        }
        return result;
    }
}