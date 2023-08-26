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
    class Pair{
        int level;
        int depth;
        TreeNode root;
        Pair(int l, int d, TreeNode r) {
            level = l; depth = d; root = r;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        List<List<Integer>> result = new ArrayList<>();

        q.add(new Pair(0,0,root));
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int level = top.level;
            int depth = top.depth;
            TreeNode curr = top.root;
            if(curr.left!=null) q.add(new Pair(level-1, depth+1,curr.left));
            if(curr.right!=null) q.add(new Pair(level+1, depth+1,curr.right));

            if(!map.containsKey(level)) {
                Map<Integer, PriorityQueue<Integer>> tempMap = new TreeMap<>();
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(curr.val);
                tempMap.put(depth, pq);
                map.put(level, tempMap);
            } else {
                Map<Integer, PriorityQueue<Integer>> tempMap = map.get(level);
                if(!tempMap.containsKey(depth)) {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(curr.val);
                    tempMap.put(depth, pq);
                    map.put(level, tempMap);
                } else {
                    PriorityQueue<Integer> pq = tempMap.get(depth);
                    pq.add(curr.val);
                    tempMap.put(depth, pq);
                    map.put(level, tempMap);
                }
            }
        }

        for(Map<Integer, PriorityQueue<Integer>> entry:map.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> priority:entry.values()) {
                while(!priority.isEmpty()) list.add(priority.poll());
            }
            result.add(list);
        }

        return result;
    }
}