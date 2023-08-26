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
    public void rec(TreeNode root) {
        if(root==null) return;
        rec(root.right);
        rec(root.left);
        TreeNode curr = root.right;
        root.right=root.left;
        root.left=curr;
    }
    public TreeNode invertTree(TreeNode root) {
        rec(root);
        return root;
    }
}