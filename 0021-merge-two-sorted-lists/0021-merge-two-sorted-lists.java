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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1=list1;
        ListNode curr2=list2;
        ListNode res = null;
        ListNode curr = null;
        while(curr1!=null && curr2!=null) {
            if(res==null) {
                if(curr1.val<curr2.val) {
                    res=curr1;
                    curr1=curr1.next;
                } else {
                    res=curr2;
                    curr2=curr2.next;
                }
                curr=res;
            } else {
                if(curr1.val<curr2.val) {
                    curr.next=curr1;
                    curr1=curr1.next;
                } else {
                    curr.next = curr2;
                    curr2=curr2.next;
                }
                curr=curr.next;
            }
        }
        
        if(res==null && curr1!=null) res=curr1;
        
        if(curr!=null && curr2!=null) {
            curr.next=curr2;
        }

        if(res==null && curr2!=null) res=curr2;
        if(curr!=null && curr1!=null) {
            curr.next=curr1;
        }
        

        return res;
    }
}