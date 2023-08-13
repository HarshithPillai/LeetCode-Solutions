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
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        
        while(curr!=null) {
            list.add(0,curr.val);
            //System.out.println(curr.val);
            curr = curr.next;
        }
        if(list.size()<2) return true;

        //look for a value that is not matching with the reversed one, return false if found
        curr=head;
        int i=0;
        while(curr!=null) {
            if(curr.val!=list.get(i)) return false;
            //System.out.println(curr.val+" "+list.get(i));
            curr=curr.next;
            i++;
        }

        return true;
    }
}