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
    class Pair{
        int level;
        TreeNode root;
        Pair(int l, TreeNode r) {
            level=l; root=r;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1, root));
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int level = top.level;
            TreeNode curr = top.root;

            if(result.size()<level) {
                List<Integer> temp = new ArrayList<>();
                temp.add(curr.val);
                result.add(temp);
            } else {
                result.get(level-1).add(curr.val);
            }

            if(curr.left!=null) q.add(new Pair(level+1, curr.left));
            if(curr.right!=null) q.add(new Pair(level+1, curr.right));
        }

        return result;
    }
}