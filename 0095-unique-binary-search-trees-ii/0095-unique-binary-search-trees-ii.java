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
    public List<TreeNode> createTree(int s, int e) {
        if(s == e) {
            return List.of(new TreeNode(s));
        }
        // if(s == e-1) {
        //     TreeNode a = new TreeNode(s);
        //     TreeNode b = new TreeNode(e);
        //     a.right = b;
        //     TreeNode c = new TreeNode(s);
        //     TreeNode d = new TreeNode(e);
        //     d.left = c;
        //     List<TreeNode> lt = new ArrayList<>();
        //     lt.add(a);
        //     lt.add(d);
        //     return lt;
        // }
        List<TreeNode> res = new ArrayList<>();
        if(s > e) return res;
        for(int i = s; i<=e; i++) {
            List<TreeNode> left = createTree(s, i-1);
            List<TreeNode> right = createTree(i+1, e);
            if(left.size() > 0 && right.size() > 0) {
                for(TreeNode l:left) {
                    for(TreeNode r:right) {
                        TreeNode newNode = new TreeNode(i);
                        newNode.left = l;
                        newNode.right = r;
                        res.add(newNode);
                    }
                }
            } else if(left.size() > 0) {
                for(TreeNode l:left) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = l;
                    res.add(newNode);
                }
            } else if(right.size() > 0) {
                for(TreeNode r:right) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.right = r;
                    res.add(newNode);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        return createTree(1,n);
    }
}