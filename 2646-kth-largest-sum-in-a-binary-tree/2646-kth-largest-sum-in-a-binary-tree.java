/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b)->Long.compare(a,b));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for(int i=0; i<size; i++) {
                TreeNode top = q.poll();
                sum += top.val;
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
            }
            if(pq.size() == k) {
                if(pq.peek() < sum) {
                    pq.poll();
                    pq.add(sum);
                }
            } else pq.add(sum);
        }
        if(pq.size() < k) return -1;
        return pq.poll();
    }
}

// 5, 17, 13, 10