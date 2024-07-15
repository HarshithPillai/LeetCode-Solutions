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
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int desc[] : descriptions) {
            int par = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2]==1;
            if(map.containsKey(par) && !map.containsKey(child)) {
                TreeNode ch = new TreeNode(child);
                if(isLeft) {
                    map.get(par).left = ch;
                } else {
                    map.get(par).right = ch;
                }
                map.put(child, ch);
            } else if(!map.containsKey(par) && map.containsKey(child)) {
                TreeNode parent = new TreeNode(par);
                if(isLeft) {
                    parent.left = map.get(child);
                } else {
                    parent.right = map.get(child);
                }
                map.put(par, parent);
            } else if(map.containsKey(par) && map.containsKey(child)) {
                if(isLeft) {
                    map.get(par).left = map.get(child);
                } else {
                    map.get(par).right = map.get(child);
                }
            } else {
                TreeNode node = new TreeNode(par);
                TreeNode ch = new TreeNode(child);
                if(isLeft) {
                    node.left = ch;
                } else {
                    node.right = ch;
                }
                map.put(par, node);
                map.put(child, ch);
            }
            children.add(child);
        }
        for(Map.Entry<Integer, TreeNode> node:map.entrySet()) {
            if(!children.contains(node.getKey())) {
                root = node.getValue();
                break;
            }
        }
        return root;
    }
}