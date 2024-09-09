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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode curr = head;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        int numInOne = size/k, extras = size%k, ind = 0;
        if(numInOne == 0) {
            numInOne = 1;
            extras = 0;
        }
        System.out.println(numInOne + " " + extras);
        curr = head;
        ListNode[] ans = new ListNode[k];
        while(curr!=null) {
            ans[ind++] = curr;
            
            for(int i=0; i<numInOne-1; i++) {
                curr = curr.next;
            }
            if(extras > 0) {
                extras--;
                curr = curr.next;
            }
            ListNode temp = curr;
            curr = curr.next;
            temp.next = null;
        }
        return ans;
    }
}