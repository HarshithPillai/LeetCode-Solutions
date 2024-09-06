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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for(int i:nums) s.add(i);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = head, prev = dummy;
        while(curr != null) {
            if(s.contains(curr.val)) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}