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
    ListNode dummy, second;
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        second = slow.next;
        dummy = new ListNode(-1);
        dummy.next = head;
        Stack<ListNode> st = new Stack<>();
        
        while(slow != null) {
            st.push(slow);
            slow = slow.next;
        }
        while(!st.isEmpty()) {
            ListNode top = st.pop();
            top.next = head.next;
            head.next = top;
            head = top.next;
        }
        head.next = null;
    }
}