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
        int first;
        TreeNode second;
        Pair(int f, TreeNode s) { first = f; second = s;}
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        q.add(new Pair(1, root));
        while(!q.isEmpty()) {
           Pair top = q.poll();
           int level = top.first;
           TreeNode node = top.second;
           if(res.size()<level) res.add(new ArrayList<>());
           res.get(level-1).add(node.val);
           
           if(node.left !=null) q.add(new Pair(level+1, node.left));
           if(node.right!=null) q.add(new Pair(level+1, node.right));
        }
        return res;
    }
}