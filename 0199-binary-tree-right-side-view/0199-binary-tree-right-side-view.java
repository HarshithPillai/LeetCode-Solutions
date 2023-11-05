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
    class Pair {
        int level, value;
        Pair(int l, int v) { level=l; value=v; }
    }
    void dfs(Map<Integer, Pair> map, TreeNode node, int level, int depth) {
        if(node==null) return;
        if(!map.containsKey(depth)) {
            map.put(depth, new Pair(level, node.val));
        }
        dfs(map, node.right, level+1, depth+1);
        dfs(map, node.left, level-1, depth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Pair> map = new TreeMap<>();
        dfs(map, root, 0, 0);
        List<Integer> list = new ArrayList<>();
        for(Pair p:map.values()) {
            list.add(p.value);
        }
        return list;
    }
}