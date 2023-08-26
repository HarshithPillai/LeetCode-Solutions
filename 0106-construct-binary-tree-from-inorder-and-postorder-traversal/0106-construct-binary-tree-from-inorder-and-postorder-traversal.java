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
    public TreeNode recutil(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart>inEnd || postStart>postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int length = index-inStart;
        root.left =recutil(inorder, inStart, index-1, postorder, postStart, postStart+length-1, map);
        root.right=recutil(inorder, index+1,   inEnd, postorder, postStart+length, postEnd-1, map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n=inorder.length;
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return recutil(inorder, 0, n-1, postorder, 0, n-1, map);
    }
}