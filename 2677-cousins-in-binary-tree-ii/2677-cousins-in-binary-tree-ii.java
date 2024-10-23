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
    public void dfs(TreeNode node, List<Integer> levelSum, int level) {
        if(node == null) return;
        if(level < 2) {
            node.val = 0;
        }
        int curr = ((node.left!=null)?node.left.val:0) + ((node.right!=null)?node.right.val:0);
        if(node.left != null) node.left.val = levelSum.get(level+1) - curr;
        if(node.right != null) node.right.val = levelSum.get(level+1) - curr;
        dfs(node.left, levelSum, level+1);
        dfs(node.right, levelSum, level+1);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size(), sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode top = q.poll();
                sum += top.val;
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            levelSum.add(sum);
        }
        dfs(root, levelSum, 0);
        return root;
    }
}