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
    boolean ans=false;
    public void recutil(TreeNode root, int k, Set<Integer> set) {
        if(root==null) return;
        recutil(root.left, k, set);
        if(set.contains(k-root.val)) {
            ans=true;
            return;
        }
        set.add(root.val);
        recutil(root.right, k, set);
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();
        recutil(root, k, set);
        return ans;
    }
}