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
class FindElements {

    Set<Integer> set = new HashSet<>();

    private void helper(TreeNode node, int val) {
        set.add(val);
        if (node.left != null) helper(node.left, val * 2 + 1);
        if (node.right != null) helper(node.right, val * 2 + 2);
    }

    public FindElements(TreeNode root) {
        helper(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */