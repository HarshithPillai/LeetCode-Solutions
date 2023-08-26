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
    int max=0;
    public void recutil(TreeNode root, int level) {
        if(root==null) return;
        if(max<level) max=level;
        recutil(root.left, level+1);
        recutil(root.right, level+1);
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        recutil(root, 1);
        return max;
    }
}