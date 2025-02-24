class Solution {
    int n, m, ans = -(int)1e9;
    public boolean getBobPath(int node, List<List<Integer>> adj, int parent, List<Integer> bobPath) {
        if (node == 0) return true;
        for(int nbr : adj.get(node)) {
            if(nbr != parent) {
                bobPath.add(nbr);
                if(getBobPath(nbr, adj, node, bobPath)) return true;
                bobPath.remove(bobPath.size() - 1);
            }
        }
        return false;
    }
    // dfs(bobPath, 0, 0, -1, vis, adj)
    public void dfs(List<Integer> bobPath, int bobIndex, int alice, int aliceParent, int[] visAlice, int[] visBob, List<List<Integer>> adj, int[] amount, int val) {
        int res = ((visAlice[alice] == 0 && visBob[alice] == 0) ? amount[alice] : 0);
        int bob = ((bobIndex < m) ? bobPath.get(bobIndex) : -1);
        if (bob == alice) {
            // System.out.println("MIDPOINT -> " + bob + " res -> " + res + " vis[] -> ");
            // for(int i:vis) {
            //     System.out.print(i + " ,");
            // }
            // System.out.println("");
            res /= 2;
        }

        visAlice[alice] = 1;
        
        if(adj.get(alice).size() == 1 && adj.get(alice).get(0) == aliceParent) {
            ans = Math.max(ans, val + res);
            // System.out.println("ans -> "+ans +" alice node -> "+alice);
            return;
        }
        int next = -(int)1e8;
        if (bob != -1) visBob[bob] = 1;

        for(int nbr : adj.get(alice)) {
            if(aliceParent != nbr) {
                dfs(bobPath, bobIndex + 1, nbr, alice, visAlice, visBob, adj, amount, val + res);
            }
        }

        visAlice[alice] = 0;
        if (bob != -1) visBob[bob] = 0;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj = new ArrayList<>();
        n = amount.length;
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] visAlice = new int[n], visBob = new int[n];
        List<Integer> bobPath = new ArrayList<>();
        bobPath.add(bob);
        getBobPath(bob, adj, -1, bobPath);
        m = bobPath.size();

        dfs(bobPath, 0, 0, -1, visAlice, visBob, adj, amount, 0);

        return ans;
    }
}