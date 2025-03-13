class Solution {
    int[][] ans;
    List<Integer> path = new ArrayList<>();
    public int[][] validArrangement(int[][] pairs) {
        /**
            create the graph
            keep the intersection point in global
            do dfs and if any one is valid return the int[][] array
        */

        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int[] ed : pairs) {
            int u = ed[0], v = ed[1];
            if (!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            adj.get(u).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            outdegree.put(v, outdegree.getOrDefault(v, 0) - 1);
        }

        int n = pairs.length, start = pairs[0][0];
        ans = new int[n][2];
        for (Map.Entry<Integer, Integer> entry : outdegree.entrySet()) {
            int node = entry.getKey(), out = entry.getValue();
            if (out > 0) {
                start = node;
                break;
            }
        }
        dfs(adj, start);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            int nd = path.get(i);
            if (i > 0) ans[i - 1][1] = nd;
            if (i < n) ans[i][0] = nd;
        }
        return ans;
    }

    public void dfs(Map<Integer, List<Integer>> adj, int node) {
        if (adj.containsKey(node)) {
            List<Integer> lt = adj.get(node);
            while (!lt.isEmpty()) {
                int val = lt.remove(lt.size() - 1);
                dfs(adj, val);
            }
        }
        path.add(node);
    }
}