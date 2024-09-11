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
    public int gcd(int a, int b) {
        if(b>a) return gcd(b,a);
        if(a%b==0) return b;
        return gcd(a-b, b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while(curr.next != null) {
            int a = curr.val, b = curr.next.val;
            int val = gcd(a,b);
            ListNode newNode = new ListNode(val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        return head;
    }
}