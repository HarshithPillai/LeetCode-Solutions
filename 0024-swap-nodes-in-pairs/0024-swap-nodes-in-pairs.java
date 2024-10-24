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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head, next = head.next, dummy = new ListNode(-1), prev = dummy;
        dummy.next = head;
        while(true) {
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            if(curr.next == null) break;
            curr = curr.next;
            if(curr.next == null) break;
            next = curr.next;
        }
        return dummy.next;
    }
}