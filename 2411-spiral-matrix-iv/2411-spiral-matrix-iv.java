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
    int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
    public boolean isValid(int[][] ans, int newr, int newc, int m, int n) {
        return (newr>=0 && newc>=0 && newr<m && newc<n && ans[newr][newc] == -1);
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for(int[] arr:ans) Arrays.fill(arr, -1);
        int dir=0, changed = 0, i=0, j=0;
        while(head != null && changed<2) {
            ans[i][j] = head.val;
            int newr = i+dx[dir%4], newc = j+dy[dir%4];
            if(isValid(ans, newr, newc, m, n)) {
                i=newr;
                j=newc;
                head = head.next;
                changed=0;
            } else {
                dir++;
                changed++;
            }
        }
        return ans;
    }
}