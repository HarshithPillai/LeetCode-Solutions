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
    TreeNode result = null;
    public int recutil(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return 0;
        int left = recutil(root.left, p, q);
        int right = recutil(root.right, p, q);
        int curr=0;
        if(root==q || root==p) {
            if(left+right==1 && result==null) result=root;
            else curr=1;
        }
        if(left+right==2 && result==null) result=root;
        
        return left+right+curr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recutil(root, p, q);
        return result;
    }
}