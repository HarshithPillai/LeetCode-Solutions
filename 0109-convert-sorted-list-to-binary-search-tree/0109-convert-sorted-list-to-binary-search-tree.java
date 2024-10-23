/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode dfs(List<Integer> lt, int s, int e) {
        if(s == e) return new TreeNode(lt.get(s));
        if(s > e) return null;
        int mid = s + (e-s)/2;
        TreeNode res = new TreeNode(lt.get(mid));
        res.left = dfs(lt, s, mid-1);
        res.right = dfs(lt, mid+1, e);
        return res;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> lt = new ArrayList<>();
        while(head != null) {
            lt.add(head.val);
            head = head.next;
        }
        return dfs(lt, 0, lt.size()-1);
    }
}