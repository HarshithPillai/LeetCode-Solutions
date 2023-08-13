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

        // boolean evenFlag=false;
        // if(fast.next!=null) evenFlag=true;

        // if(evenFlag) {

        // }
        ListNode currRev = slow.next;

        ListNode prev = null;
        ListNode next = currRev.next;
        while(currRev!=null) {
            currRev.next=prev;
            prev=currRev;
            currRev=next;
            if(next!=null)next=next.next;

        }
        slow.next=prev;
        currRev=slow.next;
        fast=head;
        while(currRev!=null) {
            System.out.println(currRev.val);
            if(fast.val!=currRev.val) return false;
            fast=fast.next;
            currRev=currRev.next;
        }
        return true;
    }
}