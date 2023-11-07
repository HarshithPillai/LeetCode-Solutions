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
    int ans=0;
    public void dfs(TreeNode node, int ind) {
        if(node==null) return;
        if(ind>ans) ans=ind;
        if(node.right!=null) dfs(node.right, ind*2+2);
        if(node.left !=null) dfs(node.left, ind*2+1);
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        dfs(root, 0);
        return ans+1;
    }
}