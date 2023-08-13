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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if(fast==null || fast.next==null) return true;

        while(fast.next!=null && fast.next.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode currRev = slow.next;
        ListNode prev = null;
        ListNode next = null;
        while(currRev!=null) {
            next=currRev.next;
            currRev.next=prev;
            prev=currRev;
            currRev=next;
        }
        slow.next=prev;
        fast=head;
        while(prev!=null) {
            if(fast.val!=prev.val) return false;
            fast=fast.next;
            prev=prev.next;
        }
        return true;
    }
}