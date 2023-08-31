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
    int maxans=Integer.MIN_VALUE;
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
        
        if(left!=null && right!=null 
                && left.valid && right.valid 
                && root.val<right.minyet && root.val>left.maxyet) {

            int curr=left.sum+right.sum+root.val;
            maxans = Math.max(maxans, curr);
            return new Pair(true, left.minyet, right.maxyet, curr);
        }
        else if(left!=null && right==null && left.valid && root.val>left.maxyet) {
            int curr=left.sum+root.val;
            maxans = Math.max(maxans, curr);
            return new Pair(true, left.minyet, root.val, curr);
        }
        else if(right!=null && left==null && right.valid && root.val<right.minyet) {
            int curr=right.sum+root.val;
            maxans = Math.max(maxans, curr);
            return new Pair(true, root.val, right.maxyet, curr);
        } else if(left==null && right==null) {
            maxans=Math.max(maxans, root.val);
            return new Pair(true, root.val, root.val, root.val);
        }
        return new Pair(false, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    public int maxSumBST(TreeNode root) {
        if(root==null) return 0;
        recutil(root);
        return Math.max(maxans,0);
    }
}