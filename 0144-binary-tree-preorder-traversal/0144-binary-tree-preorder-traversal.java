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
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        while(curr!=null) {
            if(curr.left == null) {
                res.add(curr.val);
                curr=curr.right;
            } else {
                TreeNode thread = curr.left;
                while(thread.right!=null && thread.right!=curr) thread=thread.right;
                if(thread.right==null) {
                    thread.right=curr;
                    res.add(curr.val);
                    curr=curr.left;
                } else {
                    thread.right = null;
                    curr=curr.right;
                }
            }
        }
        return res;
    }
}