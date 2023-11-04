/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void dfs(Map<Integer, Map<Integer, PriorityQueue<Integer>>> map, TreeNode root, int level, int dist) {
        if(root==null) return;
        
        if(map.containsKey(level)) {
            Map<Integer, PriorityQueue<Integer>> entry = map.get(level);
            if(entry.containsKey(dist)) {
                entry.get(dist).add(root.val);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(root.val);
                entry.put(dist, pq);
            }
        } else {
            Map<Integer, PriorityQueue<Integer>> entry = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(root.val);
            entry.put(dist, pq);
            map.put(level, entry);
        }
        dfs(map, root.left, level-1, dist+1);
        dfs(map, root.right, level+1, dist+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        
        dfs(map, root, 0, 0);
        
        for(Map<Integer, PriorityQueue<Integer>> mapentry:map.values()) {
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq: mapentry.values()) {
                while(!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            res.add(temp);
        }
        return res;
    }
}