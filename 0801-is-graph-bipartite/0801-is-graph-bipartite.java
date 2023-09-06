class Solution {
    public boolean helper(int[][] graph, int[] visited, int node) {
        Queue<Integer> q = new LinkedList<>();
        int parentColor=0, currentColor=1;
        q.add(node);
        while(!q.isEmpty()) {
            int top = q.poll();
            parentColor  = visited[top];
            currentColor = 1-parentColor;
            for(int num:graph[top]) {
                if(visited[num]==-1) {
                    visited[num]=currentColor;
                    q.add(num);
                } else if(visited[num]==parentColor) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] visited = new int[n];
        for(int i=0; i<n; i++) {
            visited[i]=-1;
        }
        for(int i=0; i<n; i++) {
            for(int num:graph[i]) {
                if(visited[num]==-1) {
                    visited[num]=0;
                    if(helper(graph, visited, num)==false) return false;
                }
            }
        }
        return true;
    }
}