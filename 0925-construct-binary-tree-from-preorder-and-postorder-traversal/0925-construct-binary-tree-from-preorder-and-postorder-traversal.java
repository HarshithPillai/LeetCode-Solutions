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
    public TreeNode helper(Map<Integer, Integer> map, int[] preorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root;
        int postIndex = map.get(preorder[preStart+1]), len = postIndex - postStart + 1;
        root.left = helper(map, preorder, preStart + 1, preStart + len, postStart, postIndex);
        root.right = helper(map, preorder, preStart + len + 1, preEnd, postIndex + 1, postEnd - 1);

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        /**
            preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
                     1
                  /    \
                 2      3
                / \    / \
               4   5  6   7
            
            preorder 1 2 4 5 3 6 7
            postorder 
        */

        Map<Integer, Integer> postIndices = new HashMap<>();
        int n = preorder.length;
        
        for (int i = 0; i < n; i++) {
            postIndices.put(postorder[i], i);
        }

        return helper(postIndices, preorder, 0, n-1, 0, n-1);
    }
}