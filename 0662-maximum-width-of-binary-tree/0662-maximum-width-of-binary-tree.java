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
    class Pair{
        long minInd;
        long maxInd;
        Pair(long m, long n) {
            minInd=m; maxInd=n;
        }
    }
    public void recutil(TreeNode root, Map<Integer, Pair> map, long ind, int level) {
        if(root==null) return;
        if(!map.containsKey(level)) {
            Pair p = new Pair(ind, ind);
            map.put(level, p);
        } else {
            Pair pair = map.get(level);
            long currmin = pair.minInd;
            long currmax = pair.maxInd;
            if(ind<currmin) {
                pair.minInd=ind;
            }
            if(ind>currmax) {
                pair.maxInd=ind;
            }
            map.put(level, pair);
        }
        recutil(root.left, map, ind*2, level+1);
        recutil(root.right, map, ind*2+1, level+1);
    }
    public int widthOfBinaryTree(TreeNode root) {    
        Map<Integer, Pair> map = new HashMap<>();
        recutil(root, map, 0, 0);
        long max=0;
        
        for(Pair p: map.values()) {
            if(max<p.maxInd-p.minInd+1) max=p.maxInd-p.minInd+1;
        }
        return (int)max;
    }
}