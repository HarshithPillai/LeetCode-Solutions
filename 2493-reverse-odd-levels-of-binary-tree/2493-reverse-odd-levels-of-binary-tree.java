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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Stack<Integer> second = new Stack<>();
        List<Integer> lt = new ArrayList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(level % 2 == 0) {
                    lt.add(node.val);
                    continue;
                }

                second.add(node.val);            
            }
            while(!second.isEmpty()) {
                lt.add(second.pop());
            }
            level++;
        }
        int ind = 0;
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode top = q.poll();
            top.val = lt.get(ind++);
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
        return root;
    }
}