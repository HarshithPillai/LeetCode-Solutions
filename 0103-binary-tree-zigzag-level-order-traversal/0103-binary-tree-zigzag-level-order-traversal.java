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
        int level;
        TreeNode node;
        Pair(int l, TreeNode n) { level = l; node = n; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, root));
        /**
            if(level%2==0) add right node and left node
            else add left node then right node
        */
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int level = top.level;
            TreeNode node = top.node;
            if(res.size()==level) res.add(new ArrayList());
            res.get(level).add(node.val);
        
            if(node.left!=null) q.add(new Pair(level+1,node.left));
            if(node.right!=null) q.add(new Pair(level+1,node.right));
            
        }
        for(int i=1; i<res.size(); i+=2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}