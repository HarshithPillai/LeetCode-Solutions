class Solution {
    long ans = 0, s;
    public long dfs(int node, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;
        long totalEdges = 1; // total number of people that will return from this node
        for(int nbr:adj.get(node)) {
            if(vis[nbr] == 0) {
                totalEdges += dfs(nbr, adj, vis);
            }
        }
        if(node != 0) {
            long cars = totalEdges/s;
            if(totalEdges % s != 0) cars++;
            ans += cars;
        }
        return totalEdges;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        /**
            IMPORTANT NOTE: a representative can switch cars whenever possible
            so no need to maintain a count of cars and fuel
            just do dfs from 0 to leaf nodes 
            and in back track check total number of cars based on edges travelled from all subtrees till this node 
            [this got returned from previous dfs calls]

            keep global variable ans
            on backtrack check total cars [total edges travelled by subtrees + 1 [current node (!=0)]]
            add the fuel required to travel this one edge, one where we are back tracking through
            [ceil(edges/seats) = total cars required] and add this value to global ans
        */
        int max = 0;
        s = seats;
        for(int[] road:roads) {
            int u = road[0];
            int v = road[1];
            max = Math.max(u, max);
            max = Math.max(v, max);
        }
        int n = max+1;
        int[] vis = new int[n];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int[] road:roads) {
            int u = road[0];
            int v = road[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0, adj, vis);
        return ans;
    }
}