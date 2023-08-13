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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        ListNode last= null;
        
        if(head==null || head.next==null) return head;
        int size=0;
        while(curr!=null) {
            size++;
            if(curr.next==null) last=curr;
            curr=curr.next;

        }
        k = k % size;
        if(k==0) return head;
        curr=head;
        int i=1;
        while(i<size-k) {
            curr=curr.next;
            i++;
        }
        ListNode res = curr.next;

        curr.next=null;
        last.next=head;

        return res;
    }
}