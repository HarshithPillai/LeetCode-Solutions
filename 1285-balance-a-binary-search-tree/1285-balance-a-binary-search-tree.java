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
    List<Integer> list = new ArrayList<>();
    TreeNode newRoot;
    public TreeNode insertDfs(int s, int e) {
        if(s>e) return null;
        int mid = (e+s)/2;
        TreeNode curr = new TreeNode(list.get(mid));
        curr.left = insertDfs(s, mid-1);
        curr.right = insertDfs(mid+1, e);
        return curr;
    }
    public void dfs(TreeNode node) {
        if(node==null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    public TreeNode balanceBST(TreeNode root) {
        dfs(root);
        int mid = list.size()/2;
        newRoot = new TreeNode(list.get(mid));
        newRoot.left = insertDfs(0, mid-1);
        newRoot.right = insertDfs(mid+1, list.size()-1);
        return newRoot;
    }
}