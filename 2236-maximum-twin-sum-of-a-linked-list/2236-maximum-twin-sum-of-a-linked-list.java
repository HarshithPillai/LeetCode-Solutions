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
class Solution {
    ListNode curr;
    int max = 0;
    public void backtrack(ListNode current) {
        if(current == null) return;
        backtrack(current.next);
        max = Math.max(curr.val + current.val, max);
        curr = curr.next;
    }
    public int pairSum(ListNode head) {
        curr = head;
        ListNode slow = head, fast = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        backtrack(slow);
        return max;
    }
}