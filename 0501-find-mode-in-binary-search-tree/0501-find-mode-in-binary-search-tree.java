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
    Map<Integer, Integer> lt;
    public void dfs(TreeNode node) {
        if(node == null) return;
        lt.put(node.val, lt.getOrDefault(node.val, 0) + 1);
        dfs(node.left);
        dfs(node.right);
    }
    public int[] findMode(TreeNode root) {
        lt = new HashMap<>();
        dfs(root);
        int currVal = 0, count = 0;
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:lt.entrySet()) {
            int val = entry.getKey(), freq = entry.getValue();
            if(count < freq) {
                currVal = val;
                count = freq;
                res = new ArrayList<>();
                res.add(val);
            } else if (count == freq) {
                res.add(val);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}