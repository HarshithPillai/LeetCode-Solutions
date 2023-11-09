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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode leaf = root;
        if(root==null) return root=new TreeNode(val);
        while(true) {
            if(val>leaf.val) {
                if(leaf.right!=null) leaf = leaf.right;
                else break;
            } else {
                if(leaf.left!=null)leaf = leaf.left;
                else break;
            }
        }
        TreeNode node = new TreeNode(val);
        if(val<leaf.val) leaf.left = node;
        else leaf.right = node;
        return root;
    }
}