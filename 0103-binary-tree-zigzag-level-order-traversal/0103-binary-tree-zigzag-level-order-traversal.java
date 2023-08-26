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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        q.add(root);
        boolean flag=true;        
        while(!q.isEmpty()) {
            List<Integer> temp = new ArrayList();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode top = q.peek();
                if(flag) temp.add(top.val);
                else temp.add(0, top.val);
                if(top.left!=null) q.add(top.left);
                if(top.right!=null) q.add(top.right);
                q.poll();
            }
            flag=!flag;
            result.add(temp);
        }

        return result;
    }
}