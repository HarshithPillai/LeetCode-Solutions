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
    boolean flag = true;
    class Pair {
        int min, max;
        Pair(int i, int x) { min=i; max=x; }
    }
    public Pair helper(TreeNode node) {
        if(node.left==null && node.right==null) {
            return new Pair(node.val, node.val);
        }
        Pair left, right;
        int min = node.val, max = node.val;
        if(node.left != null) {
            left = helper(node.left);
            if(left.max >= node.val) flag = false;
            min=Math.min(min, left.min);
        }
        if(node.right!=null) {
            right = helper(node.right);
            if(right.min <= node.val) flag = false;
            max=Math.max(max, right.max);
        }
        return new Pair(min, max);
    }
    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;        
    }
}