class Solution {
    public boolean bfs(int[][] graph, int[] colours, int src) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});
        while(!q.isEmpty()) {
            int front[] = q.poll();
            int node = front[0];
            int colour = front[1];
            int next = colour^1;
            for(int nbr:graph[node]) {
                if(colours[nbr] == next) continue;
                if(colours[nbr] == -1) {
                    colours[nbr] = next;
                    q.add(new int[]{nbr, next});
                } else return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length, colours[] = new int[n];
        Arrays.fill(colours, -1);
        for(int i=0; i<n; i++) {
            if(colours[i] == -1) {
                if(!bfs(graph, colours, i)) return false;
            }
        }
        return true;
    }
}