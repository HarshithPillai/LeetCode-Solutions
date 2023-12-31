/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right,p,q);
        int curr=0;
        if(root==p || root==q) curr=1;
        if(left+right+curr==2 && res==null) res = root;
        return left+right+curr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }
}