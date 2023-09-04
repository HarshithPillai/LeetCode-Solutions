class Solution {
    public void recutil(int[][] isConnected, int node, int[] visited, int n) {
        visited[node]=1;
        for(int i=0; i<n; i++) {
            if(isConnected[i][node]==1 && visited[i]==0) recutil(isConnected, i, visited, n);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int components=0;
        int[] visited = new int[n];

        for(int i=0; i<n; i++) {
            if(visited[i]==0) {
                components++;
                recutil(isConnected, i, visited, n);
            }
        }
        return components;
    }
}