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
    TreeNode first,second;
    TreeNode prev;
    public void dfs(TreeNode node) {
        if(node==null) return;
        dfs(node.left);
        if(prev.val>node.val) {
            if(first==null) {
                first=prev;
                second=node;
            } else {
                second=node;
            }
        }
        prev=node;
        dfs(node.right);
    }
    public void recoverTree(TreeNode root) {
        prev=new TreeNode(Integer.MIN_VALUE);
        dfs(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }
}