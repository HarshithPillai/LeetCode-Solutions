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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode curr1=l1, curr2=l2;
        
        int carry=(l1.val+l2.val)/10;
        ListNode result = new ListNode((l1.val+l2.val)%10,null);
        ListNode curr = result;
        curr1=curr1.next;
        curr2=curr2.next;
        while(curr1!=null && curr2!=null) {
            int sum = curr1.val+curr2.val+carry;
            carry = sum/10;
            ListNode newNode = new ListNode((sum)%10,null);
            //System.out.println(l1.val + " " +l2.val +" "+ carry);

            curr.next=newNode;
            curr1=curr1.next;
            curr2=curr2.next;
            curr=curr.next;
        }
        while(curr1!=null) {
            int sum = curr1.val+carry;
            carry = sum/10;
            ListNode newNode = new ListNode((sum)%10,null);
            curr.next=newNode;
            curr1=curr1.next;
            curr=curr.next;
        }
        while(curr2!=null) {
            int sum = curr2.val+carry;
            carry = sum/10;
            ListNode newNode = new ListNode((sum)%10,null);
            curr.next=newNode;
            curr2=curr2.next;
            curr=curr.next;
        }
        if(carry>0) {
            ListNode newNode = new ListNode(carry, null);
            curr.next = newNode;
        }

        return result;
        
    }
}