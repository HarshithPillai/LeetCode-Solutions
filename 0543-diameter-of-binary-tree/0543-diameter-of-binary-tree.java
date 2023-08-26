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
    public int recutil(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) {
            return 1;
        }
        int left=0, right=0;
        left  += recutil(root.left);
        right += recutil(root.right);
        int total = left+right;
        if(max<total) max=total;
        return Math.max(left, right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        recutil(root);
        return max;
    }
}