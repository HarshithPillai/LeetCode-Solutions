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
    String ans = null;
    Map<Integer, TreeNode> map = new HashMap<>();
    public void dfs2(TreeNode node, TreeNode dest, List<TreeNode> parent, StringBuilder sb, int vis[]) {
        if(node == null) return;
        if(node.val == dest.val) {
            if(ans == null) ans = new String(sb);
            else {
                if(sb.length() < ans.length()) ans = new String(sb);
            }
            return;
        }
        vis[node.val] = 1;
        TreeNode par = parent.get(node.val);
        if(par.val != 0 && vis[par.val]==0) {
            sb.append("U");
            dfs2(par, dest, parent, sb, vis);
            sb.deleteCharAt(sb.length()-1);
        }
        if(node.left!=null && vis[node.left.val] == 0) {
            sb.append("L");
            dfs2(node.left, dest, parent, sb, vis);
            sb.deleteCharAt(sb.length()-1);
        }
        if(node.right!=null && vis[node.right.val] == 0) {
            sb.append("R");
            dfs2(node.right, dest, parent, sb, vis);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public void dfs(TreeNode root, TreeNode par, List<TreeNode> parent) {
        if(root == null) return;
        // if(par.val != 0) {
        while(parent.size() < root.val+1) {
            parent.add(null);
        }
        parent.set(root.val, par);
        // }
        map.put(root.val, root);
        dfs(root.left, root, parent);
        dfs(root.right, root, parent);
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> parent = new ArrayList<>();
        TreeNode p = new TreeNode(0);
        parent.add(p);
        dfs(root, p, parent);
        int n = parent.size();
        int[] vis = new int[n];
        // for(TreeNode pa : parent) System.out.print( pa.val + " ");
        dfs2(map.get(startValue), map.get(destValue), parent, new StringBuilder(), vis);
        return ans;
    }
}