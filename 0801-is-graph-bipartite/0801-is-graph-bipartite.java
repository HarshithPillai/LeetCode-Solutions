class Solution {
    boolean helper(int[][] graph, int start, int[] colored) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colored[start]=0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i:graph[node]) {
                if(colored[i]==-1) {
                    q.add(i);
                    colored[i]=1-colored[node];
                } else if(colored[i]==colored[node]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] colored = new int[n];
        for(int i=0;i<n;i++) colored[i]=-1;
        for(int i=0;i<n;i++) {
            if(colored[i]==-1) {
                colored[i]=0;
                if(helper(graph, i, colored)==false) return false;
            }
        }
        return true;
    }
}