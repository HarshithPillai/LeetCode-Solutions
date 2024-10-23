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
    int max = 1;
    public int[] dfs(TreeNode node) {
        if(node == null) return new int[]{-2000, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int curr = 1, returnVal = 1;
        if(left[0] == node.val) {
            curr += left[1];
            returnVal = curr;
        }
        if(right[0] == node.val) {
            curr += right[1];
            returnVal = Math.max(returnVal, right[1] + 1);
        }
        max = Math.max(max, curr);
        return new int[]{node.val, returnVal};
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max-1;
    }
}