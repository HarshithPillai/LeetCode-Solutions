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
    public void recutil(TreeNode root, List<Integer> preorder, List<Integer> postorder) {
        if(root==null) {
            postorder.add(null);
            preorder.add(null);
            return;
        }
        preorder.add(root.val);
        recutil(root.left, preorder, postorder);
        recutil(root.right, preorder, postorder);
        postorder.add(root.val);
    }
    public boolean isSymmetric(TreeNode root) {
        List<Integer> preorder  = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        recutil(root, preorder, postorder);
        int n=preorder.size();
        for(int i=0; i<n; i++) {
            //System.out.println(preorder.get(i)+" "+postorder.get(n-i-1));
            if(preorder.get(i)!=postorder.get(n-i-1)) return false;
        }
        return true;
    }
}