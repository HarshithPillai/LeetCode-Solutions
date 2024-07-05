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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{(int)1e9, 0};
        ListNode p = head, c = head.next, n = c.next;
        if(n == null) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        int found=-1, count=1, i=0;
        while(n!=null) {
            if((p.val<c.val && c.val>n.val) || (p.val>c.val && n.val>c.val)) {
                if(found!=-1) {
                    ans[0] = Math.min(ans[0], count);
                    ans[1] = Math.max(ans[1], i - found);
                } else {
                    found = i;
                }
                
                count=0;
            }
            count++;
            i++;
            
            n = n.next;
            c = c.next;
            p = p.next;
        }
        if(ans[0] == (int)1e9) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        return ans;
    }
}