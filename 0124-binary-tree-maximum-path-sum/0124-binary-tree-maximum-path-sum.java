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
    int max = Integer.MIN_VALUE;
    public int recutil(TreeNode root) {
        if(root==null) return 0;
        int left = recutil(root.left);
        int right = recutil(root.right);
        int total = left+right+root.val;
        if(max<total) max=total;
        return Math.max(Math.max(left, right)+root.val,0);
    }

    public int maxPathSum(TreeNode root) {
        recutil(root);
        return max;
    }
}