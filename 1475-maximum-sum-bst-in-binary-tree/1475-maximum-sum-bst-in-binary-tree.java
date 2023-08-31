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
    int maxans=0;
    class Pair{
        boolean valid;
        int minyet;
        int maxyet;
        int sum;
        Pair(boolean v, int mi, int mx, int s) {
            valid=v; minyet=mi; maxyet=mx; sum=s;
        }
    }
    public Pair recutil(TreeNode root) {
        Pair left=null; Pair right=null;
        if(root.left!=null) left  = recutil(root.left);
        if(root.right!=null) right = recutil(root.right);
        Pair curr = new Pair(true,root.val,root.val,root.val);
        if(left!=null) {
            curr.sum+=left.sum;
            curr.maxyet=Math.max(root.val, left.maxyet);
            curr.minyet=Math.min(root.val, left.minyet);
            curr.valid=(left.valid && left.maxyet<root.val);
        }
        if(right!=null) {
            curr.sum+=right.sum;
            curr.maxyet=Math.max(curr.maxyet, right.maxyet);
            curr.minyet=Math.min(curr.minyet, right.minyet);
            curr.valid = curr.valid && (right.valid && right.minyet>root.val);
        }
        if(curr.valid) {
            maxans=Math.max(curr.sum, maxans);
        }
        return curr;
    }
    public int maxSumBST(TreeNode root) {
        if(root==null) return 0;
        recutil(root);
        return maxans;
    }
}