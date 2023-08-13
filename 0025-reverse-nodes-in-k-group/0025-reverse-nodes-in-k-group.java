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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<2) return head;
        ListNode curr=head;
        ListNode prev=null;
        int reversed=0;
        ListNode first=curr;
        ListNode result=null;
        ListNode prevTail=null;
        int size=0;
        while(curr!=null) {
            size++;
            curr=curr.next;
        }
        curr=head;
        int count=size;
        int maxCount=size%k;
        while(curr!=null) {
            if(count==maxCount) break;
            count--;
            
            ListNode next=curr.next;
            curr.next=prev;
            reversed++;
            prev=curr;
            if(reversed==k) {
                if(prevTail==null) {
                    result=curr;
                } else {
                    prevTail.next=curr;
                }
                //first.next=next;
                //curr=first;
                prevTail=first;
                prevTail.next=next;
                //curr=prevTail;
                first=next;
                //prev=first;
                reversed=0;
            }
            
            curr=next;

        }
        
        return result;
    }
}