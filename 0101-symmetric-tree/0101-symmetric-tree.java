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
    List<Integer> preorder;
    List<Integer> postorder;
    public void recutil(TreeNode root) {
        if(root==null) {
            postorder.add(null);
            preorder.add(null);
            return;
        }
        preorder.add(root.val);
        recutil(root.left);
        recutil(root.right);
        postorder.add(root.val);
    }
    public boolean isSymmetric(TreeNode root) {
        preorder  = new ArrayList<>();
        postorder = new ArrayList<>();
        recutil(root);
        int n=preorder.size();
        for(int i=0; i<n; i++) {
            if(preorder.get(i)!=postorder.get(n-i-1)) return false;
        }
        return true;
    }
}