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
    public TreeNode helper(int[] preorder, int s, int e) {
        if(s>e) return null;
        TreeNode node = new TreeNode(preorder[s]);
        int leftInd = s+1;
        while(leftInd<=e && preorder[leftInd]<preorder[s]) leftInd++;
        node.left = helper(preorder, s+1,leftInd-1);
        node.right= helper(preorder, leftInd, e);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {     
        return helper(preorder,0,preorder.length-1);
    }
}