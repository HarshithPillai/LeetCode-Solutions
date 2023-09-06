class Solution {
    public boolean helper(int[][] graph, int[] visited, int[] path, int node, int[] check) {
        visited[node]=1;
        path[node]=1;
        for(int num:graph[node]) {
            if(visited[num]==0) {
                if(helper(graph, visited, path, num, check)) return true;
            } else if(path[num]==1) return true;
        }
        path[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] path = new int[n];
        int[] check = new int[n];
        int[] visited = new int[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            helper(graph, visited, path, i, check);
        }
        for(int i=0; i<n; i++) {
            if(check[i]==1) result.add(i);
        }
        return result;
    }
}