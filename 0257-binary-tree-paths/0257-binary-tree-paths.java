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
    public void dfs(TreeNode node, String path, List<String> list) {
        if(node.right==null && node.left==null) {
            list.add(path);
            return;
        }
        
        if(node.left!=null) dfs(node.left, path+"->"+node.left.val, list);
        if(node.right!=null) dfs(node.right, path+"->"+node.right.val, list);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root!=null) dfs(root, ""+root.val, res);
        return res;
    }
}