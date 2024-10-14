class Solution {
    public int dfs(int node, int parent, List<List<Integer>> adj, Map<Integer, Set<Integer>> map) {
        int res = 0;
        if(parent != -1) {
            if(!map.containsKey(node) || !map.get(node).contains(parent)) res++;
        }
        for(int nbr:adj.get(node)) {
            if(nbr != parent) {
                res += dfs(nbr, node, adj, map);
            }
        }
        return res;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] con:connections) {
            int u = con[0], v = con[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            if(map.containsKey(u)) {
                map.get(u).add(v);
            } else {
                Set<Integer> s =  new HashSet<>();
                s.add(v);
                map.put(u, s);
            }
        }
        return dfs(0, -1, adj, map);
    }
}