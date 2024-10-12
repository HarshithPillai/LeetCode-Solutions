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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0, max = -(int)1e9, ans = 1;
        q.add(root);
        while(!q.isEmpty()) {
            level++;
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(max < sum) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}