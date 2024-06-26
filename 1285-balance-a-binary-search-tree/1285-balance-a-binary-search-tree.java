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
    public void insert(TreeNode tree, TreeNode node) {
        int val = node.val;
        if(val>tree.val) {
            if(tree.right != null) insert(tree.right, node);
            else {
                tree.right = node;
                return;
            }
        } else {
            if(tree.left != null) insert(tree.left, node);
            else {
                tree.left = node;
                return;
            }
        }
    }
    public void insertDfs(int s, int e) {
        if(s>e) return;
        int mid = (e+s)/2;
        insert(newRoot, new TreeNode(list.get(mid)));
        insertDfs(s, mid-1);
        insertDfs(mid+1, e);
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
        insertDfs(0, mid-1);
        insertDfs(mid+1, list.size()-1);
        return newRoot;
    }
}