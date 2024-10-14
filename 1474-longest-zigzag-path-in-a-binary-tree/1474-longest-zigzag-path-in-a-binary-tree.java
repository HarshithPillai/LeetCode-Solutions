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
    int res = 0;
    public int dfs(int count, TreeNode node, int last) {
        if(node == null) return 0;
        int left = dfs(1, node.left, 0);
        int right = dfs(1, node.right, 1);
        if(last == 0) {
            count += right;
        } else count += left;
        res = Math.max(res, count);
        return count;
    }
    public int longestZigZag(TreeNode root) {
        dfs(0, root, 0);
        dfs(0, root, 1);
        return res;
    }
}