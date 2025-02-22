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
    public TreeNode recoverFromPreorder(String traversal) {
        int ind = 0;
        char[] arr = traversal.toCharArray();
        Stack<TreeNode> stack = new Stack<>();
        while(ind < arr.length) {
            int level = 0, num = 0;
            while(ind < arr.length && arr[ind] == '-') {
                level++;
                ind++;
            }

            while(ind < arr.length && arr[ind] != '-') {
                num *= 10;
                num += (arr[ind] - '0');
                ind++;
            }

            while(stack.size() > level) stack.pop();
            TreeNode newNode = new TreeNode(num);
            if(!stack.isEmpty()) {
                TreeNode top = stack.peek();
                if(top.left == null) {
                    top.left = newNode;
                } else {
                    top.right = newNode;
                }
            }
            stack.add(newNode);
        }
        while(stack.size() > 1) stack.pop();
        return stack.pop();
    }
}