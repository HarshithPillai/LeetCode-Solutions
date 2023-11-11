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
    Stack<TreeNode> beforeSt, nextSt;
    public boolean hasNext() {
        return (!nextSt.isEmpty());
    }
    public boolean hasPrev() {
        return (!beforeSt.isEmpty());
    }
    public int next() {
        TreeNode curr = nextSt.pop();
        int val = curr.val;
        if(curr.right!=null) {
            curr=curr.right;
            while(curr!=null) {
                nextSt.push(curr);
                curr=curr.left;
            }
        }
        return val;
    }
    public int prev() {
        TreeNode curr = beforeSt.pop();
        int val = curr.val;
        if(curr.left!=null) {
            curr=curr.left;
            while(curr!=null) {
                beforeSt.push(curr);
                curr=curr.right;
            }
        }
        return val;
    }
    public boolean findTarget(TreeNode root, int k) {
        nextSt = new Stack<>();
        beforeSt = new Stack<>();
        TreeNode curr = root;
        while(curr!=null) {
            nextSt.push(curr);
            curr=curr.left;
        }
        curr=root;
        while(curr!=null) {
            beforeSt.push(curr);
            curr=curr.right;
        }
        int left = next();
        int right = prev();
        while(left<right) {
            if(left+right==k) return true;
            else if(left+right>k) {
                if(hasPrev()) right=prev();
                else return false;
            } else {
                if(hasNext()) left=next();
                else return false;
            }
        }
        return false;
    }
}