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
    public void dfs(TreeNode node, List<Integer> arr) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            arr.add(node.val);
            return;
        }
        dfs(node.left, arr);
        dfs(node.right, arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();
        dfs(root1, arr1);
        dfs(root2, arr2);
        if(arr1.size() != arr2.size()) return false;
        for(int i=0; i<arr1.size(); i++) {
            // System.out.println(arr1.get(i) + " " + arr2.get(i));
            if(!arr1.get(i).equals(arr2.get(i))) return false;
        }
        return true;
    }
}