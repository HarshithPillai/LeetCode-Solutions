/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair {
        int dist; TreeNode node;
        Pair(int d, TreeNode n) { dist=d; node=n; }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(k==0) {
            res.add(target.val);
            return res;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>(); // node, parent
        //map.put(root, null);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left!=null) {
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right!=null) {
                map.put(node.right, node);
                q.add(node.right);
            }
        }

        Queue<Pair> pq = new LinkedList<>();
        int[] vis = new int[501];
        vis[target.val]=1;
        pq.add(new Pair(0, target));
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            int dist = top.dist;
            TreeNode node = top.node;
            if(dist==k) res.add(node.val);
            if(dist>k) continue;

            if(map.containsKey(node)) {
                TreeNode parent = map.get(node);
                if(vis[parent.val]==0) {
                    vis[parent.val]=1;
                    pq.add(new Pair(dist+1, parent));
                }
            }
            if(node.left!=null && vis[node.left.val]==0) {
                pq.add(new Pair(dist+1, node.left));
                vis[node.left.val]=1;
            }
            if(node.right!=null && vis[node.right.val]==0) {
                pq.add(new Pair(dist+1, node.right));
                vis[node.right.val]=1;
            }
        }
        return res;
    }
}