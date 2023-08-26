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
    public TreeNode recutil(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart,
    int preEnd, Map<Integer, Integer> map) {
        if(inStart>inEnd) return null;
        if(preStart>preEnd) return null;
        TreeNode newNode = new TreeNode(preorder[preStart]);
        int index = map.get(preorder[preStart]);
        int length= index-inStart;

        newNode.left  =recutil(inorder, preorder, inStart, index-1,        preStart+1, preStart+length, map);
        newNode.right =recutil(inorder, preorder, index+1,   inEnd, preStart+length+1,          preEnd, map);
        return newNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        if(n==0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(inorder[i], i);
        }
        return recutil(inorder, preorder, 0, n-1, 0, n-1, map);
    }
}