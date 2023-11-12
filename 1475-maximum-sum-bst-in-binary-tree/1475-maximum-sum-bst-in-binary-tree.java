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
    int max=0;
    class Return{
        int correct,size, min, max;
        Return(int c, int s, int i, int x) { correct=c; size=s; min=i; max=x; }
    }
    public Return dfs(TreeNode node) {
        if(node.left==null && node.right==null) {
            max = Math.max(node.val, max);
            return new Return(1, node.val, node.val, node.val);
        }
        Return left=null;
        Return right=null;
        if(node.left !=null) left = dfs(node.left);
        if(node.right!=null) right= dfs(node.right);
        
        if((left!=null && left.correct==0) || (right!=null && right.correct==0)) {
            return new Return(0, 0, 0, 0);
        } else {
            if((left!=null && left.max >= node.val) || (right!=null && right.min <= node.val)) {
                return new Return(0, 0, 0, 0);
            } else {
                int size = node.val;
                if(left!=null) size+=left.size;
                if(right!=null) size+=right.size;
                max = Math.max(max, size);
                if(left!=null && right!=null) return new Return(1, size, left.min, right.max);
                else if(left!=null) return new Return(1, size, left.min, node.val);
                else return new Return(1, size, node.val, right.max);
            }
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }
}