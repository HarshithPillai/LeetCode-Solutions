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
    int count=1;
    int ans=-1;
    public void recutil(TreeNode root, int k) {
        if(root==null) return;
        recutil(root.left, k);
        if(count==k) {
            ans=root.val;
            count++;
            return;
        }
        count++;
        recutil(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        recutil(root,k);
        return ans;
    }
}