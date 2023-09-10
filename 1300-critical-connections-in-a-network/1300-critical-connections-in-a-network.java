class Solution {
    int timer=1;
    public void dfs(int node, int[] t_in, int[] low, int[] visited, List<List<Integer>> adj, List<List<Integer>> result, int parent) {
        visited[node]=1;
        low[node]=timer;
        t_in[node]=timer++;
        for(int nbr:adj.get(node)) {
            if(nbr==parent) continue;
            if(visited[nbr]==0) {    
                dfs(nbr, t_in, low, visited, adj, result, node);
                low[node] = Math.min(low[nbr], low[node]);
                if(t_in[node]<low[nbr]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node);temp.add(nbr);
                    result.add(temp);
                }
            } else {
                low[node] = Math.min(low[nbr], low[node]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int t_in[] = new int[n];
        int low[] = new int[n];
        int visited[] = new int[n];

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<connections.size();i++) {
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }
        
        dfs(0, t_in, low, visited, adj, result, -1);//////////PARENT -1
        
        return result;
    }
}