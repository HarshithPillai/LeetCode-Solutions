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
        long min, max;
        Pair(long i, long x) { min=i; max=x; }
    }
    public void dfs(TreeNode root, Map<Integer, Pair> map, long index, int depth) {
        if(root==null) return;
        if(!map.containsKey(depth)) {
            map.put(depth, new Pair(index, index));
        } else {
            Pair p = map.get(depth);
            if(index<p.min) p.min=index;
            else if(index>p.max) p.max=index;
            //map.put(depth, p);
        }
        dfs(root.left, map, index*2, depth+1);
        dfs(root.right,map, index*2+1,depth+1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Pair> map = new HashMap<>();
        dfs(root, map, 0, 0);
        long max = 0;
        for(Pair p:map.values()) {
            max = Math.max(max, p.max-p.min+1);
        }
        return (int)max;
    }
}