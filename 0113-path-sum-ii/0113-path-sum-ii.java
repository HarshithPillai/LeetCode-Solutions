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
    public void dfs(List<List<Integer>> ans, TreeNode node, int sum, int target, List<Integer> curr) {
        if(node == null) return;
        sum+=node.val;
        if(node.left== null && node.right==null && sum == target) {
            curr.add(node.val);
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        curr.add(node.val);
        dfs(ans, node.left, sum, target, curr);
        dfs(ans, node.right, sum, target, curr);
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, root, 0, targetSum, new ArrayList<>());
        return ans;
    }
}