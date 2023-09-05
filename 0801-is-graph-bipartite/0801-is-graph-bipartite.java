class Solution {
    boolean helper(int[][] graph, int start, int[] colored, int parentColor) {       
        for(int i:graph[start]) {
            if(colored[i]==-1) {
                colored[i]=1-parentColor;
                if(helper(graph, i, colored, colored[i])==false) return false;
            } else if(colored[i]==parentColor) return false;
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
                if(helper(graph, i, colored, 0)==false) return false;
            }
        }
        return true;
    }
}