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
    public void morris(TreeNode node, List<Integer> res) {
        if(node==null) return;
        TreeNode curr = node;
        if(node.left==null) {
            res.add(node.val);
            morris(node.right, res);
        } else {
            node=node.left;
            while(node.right!=null && node.right!=curr) node=node.right;
            if(node.right==null) {
                node.right=curr;
                morris(curr.left, res);
            }
            else {
                node.right=null;
                res.add(curr.val);
                morris(curr.right, res);
            }
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        morris(root,res);
        return res;
    }
}