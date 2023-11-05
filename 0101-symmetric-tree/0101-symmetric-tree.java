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
    public boolean dfs(TreeNode nl, TreeNode nr) {
        if(nl==null && nr==null) return true;
        if(nl==null && nr!=null) return false;
        if(nl!=null && nr==null) return false;
        if(nl.val != nr.val) return false;
        if(dfs(nl.left, nr.right)==false) return false;
        if(dfs(nl.right, nr.left)==false) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
}