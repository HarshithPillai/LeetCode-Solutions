class Solution {
    boolean helper(int[][] graph, int start, int[] colored) {
        Queue<Integer> q = new LinkedList<>();
        int curr=0;
        q.add(start);
        while(!q.isEmpty()) {
            int top=q.poll();
            if(colored[top]==0) curr=1;
            else curr=0;
            for(int i:graph[top]) {
                if(colored[i]==-1) {
                    colored[i]=curr;
                    q.add(i);
                }
                else if(colored[i]==colored[top]) return false;
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