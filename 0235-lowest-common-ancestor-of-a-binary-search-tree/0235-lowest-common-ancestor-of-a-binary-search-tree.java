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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        if(p.val>q.val) return lowestCommonAncestor(root,q,p);
        while(true) {
            if(curr.val>=p.val && curr.val<=q.val) return curr;
            if(q.val<curr.val) curr=curr.left;
            else curr=curr.right;
        }
    }
}