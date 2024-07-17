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
    List<TreeNode> ans = new ArrayList<>();
    public void dfs(TreeNode node, Set<Integer> set) {
        if(node == null) return;
        dfs(node.left, set);
        dfs(node.right, set);
        if(set.contains(node.val)) {
            if(node.left != null) {
                if(set.contains(node.left.val)) {
                    node.left = null;
                } else {
                    ans.add(node.left);
                }
            }
            if(node.right != null) {
                if(set.contains(node.right.val)) {
                    node.right = null;
                } else {
                    ans.add(node.right);
                }
            }
        }
        if(node.left != null) {
            if(set.contains(node.left.val)) {
                node.left = null;
            }
        }
        if(node.right != null) {
            if(set.contains(node.right.val)) {
                node.right = null;
            }
        }

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i:to_delete) set.add(i);
        if(!set.contains(root.val)) ans.add(root);
        dfs(root, set);
        return ans;
    }
}