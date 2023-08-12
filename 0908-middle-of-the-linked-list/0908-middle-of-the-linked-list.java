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
    public ListNode middleNode(ListNode head) {
        int size=0;
        ListNode curr = head;
        while(curr!=null) {
            curr=curr.next;
            size++;
        }
        int mid=size/2 + 1;
        int currCount=1;
        curr=head;
        while(currCount<mid) {
            curr=curr.next;
            currCount++;
        }
        return curr;        
    }
}