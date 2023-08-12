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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;

        ListNode curr=head;
        while(curr!=null) {
            curr=curr.next;
            size++;
        }
        curr=head;
        int ind=size-n;
        if(ind<0) return head;
        if(ind==0) return head.next;
        
        for(int i=0; i<ind-1; i++) {
            curr=curr.next;
        }
        if(curr!=null) curr.next=curr.next.next;
        return head;
        
    }
}