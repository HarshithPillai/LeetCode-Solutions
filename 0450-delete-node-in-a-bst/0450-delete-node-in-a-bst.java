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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        TreeNode parent = root;
        TreeNode curr = null;
        if(root.val==key) {
            if(root.left==null) return root.right;
            else {
                TreeNode thr = root.left;
                while(thr.right!=null) thr = thr.right;
                thr.right = root.right;
                return root.left;
            }
        }
        while(true) {
            if(key>parent.val) {
                curr=parent.right;
                if(curr==null) return root;
                if(curr.val==key) {
                    break;
                } else {
                    parent = parent.right;
                }
            } else if(key<parent.val) {
                curr = parent.left;
                if(curr==null) return root;
                if(curr.val==key) {
                    break;
                } else {
                    parent = parent.left;
                }
            }
        }
        
        if(parent.left!=null && parent.left.val==key) {
            curr = parent.left;
            if(curr.left==null) {
                parent.left = curr.right;
                return root;
            } else {
                TreeNode thread = curr.left;
                while(thread.right!=null) thread = thread.right;
                thread.right = curr.right;
                parent.left = curr.left;
                return root;
            }
        } else {
            curr = parent.right;
            if(curr.left==null) {
                parent.right = curr.right;
                return root;
            } else {
                TreeNode thread = curr.left;
                while(thread.right!=null) thread = thread.right;
                thread.right = curr.right;
                parent.right = curr.left;
                return root;
            }
        }
    }
}