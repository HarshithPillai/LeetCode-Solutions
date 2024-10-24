/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        if(root.children != null && root.children.size() > 0) {
            for(Node node:root.children) {
                res.addAll(preorder(node));
            }
        }
        return res;
    }
}