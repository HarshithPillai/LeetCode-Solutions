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
class BSTIterator {

    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIterator(TreeNode curr) {
        this.root=curr;
        while(curr!=null) {
            stack.push(curr);
            curr=curr.left;
        }
    }
    
    public int next() {
        TreeNode top = stack.pop();
        int ans=top.val;
        top=top.right;
        while(top!=null) {
            stack.push(top);
            top=top.left;
        }
        return ans;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */