class Solution {
    int timer=1;
    public void dfs(int node, int[] tim, int[] low, int[] visited, List<List<Integer>> adj, List<List<Integer>> result, int parent) {
        if(visited[node]==1) return;
        visited[node]=1;
        low[node]=timer;
        tim[node]=timer++;
        for(int nbr:adj.get(node)) {
            if(nbr==parent) continue;
            dfs(nbr, tim, low, visited, adj, result, node);
            if(low[nbr]<low[node]) low[node]=low[nbr];
            if(tim[node]<low[nbr]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(node);temp.add(nbr);
                result.add(temp);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int tim[] = new int[n];
        int low[] = new int[n];
        int visited[] = new int[n];

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            low[i] = (int)1e9;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++) {
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        dfs(0, tim, low, visited, adj, result, -1);//////////PARENT -1
        return result;
    }
}