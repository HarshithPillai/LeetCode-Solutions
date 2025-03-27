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

    List<Integer> lt = new ArrayList<>();
    Random rd;
    int max, min = 0;

    public Solution(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            lt.add(curr.val);
            curr = curr.next;
        }
        max = lt.size();
        rd = new Random();
    }
    
    public int getRandom() {
        int ind = rd.nextInt(max - min) + min;
        return lt.get(ind);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */