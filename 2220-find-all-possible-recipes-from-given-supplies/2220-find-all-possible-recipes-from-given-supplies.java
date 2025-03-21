class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        /**
            map<string, integer> item -> node index
            map<integer, string> node index -> item
        */
        Map<String, Integer> itemNode = new HashMap<>();
        Map<Integer, String> nodeItem = new HashMap<>();
        List<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int index = 0, n = recipes.length;
        
        for (String r : recipes) {
            nodeItem.put(index, r);
            itemNode.put(r, index++);
        }

        for (List<String> ingred : ingredients) {
            for (String ing : ingred) {
                if (!itemNode.containsKey(ing)) {
                    nodeItem.put(index, ing);
                    itemNode.put(ing, index++);
                }
            }
        }

        int[] indegree = new int[index];
        
        for (String supply : supplies) visited.add(supply);
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            int recipeNode = itemNode.get(recipes[i]);
            for (String ing : ingredients.get(i)) {
                int ingNode = itemNode.get(ing);
                adj.get(ingNode).add(recipeNode);
                indegree[recipeNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < index; i++) {
            String item = nodeItem.get(i);
            if (indegree[i] == 0 && visited.contains(item)) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int top = q.poll();
            if (top < n) ans.add(nodeItem.get(top));
            for (int nbr : adj.get(top)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    visited.add(nodeItem.get(nbr));
                    q.add(nbr);
                }
            }
        }

        return ans;
    }
}