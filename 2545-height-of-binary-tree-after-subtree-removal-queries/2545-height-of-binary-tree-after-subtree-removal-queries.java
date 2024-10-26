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
    Map<Integer, Integer> firstMaxInLevel = new HashMap<>(), secondMaxInLevel = new HashMap<>();
    Map<Integer, Integer> nodeLevel; // node-> its level
    Map<Integer, Integer> map; // node -> max level of that subtree
    Map<Integer, Integer> ansMap;
    public int dfsSize(TreeNode node, int lvl) {
        if(node == null) return 0;
        int curr = lvl;
        curr = Math.max(curr, dfsSize(node.left, lvl+1));
        curr = Math.max(curr, dfsSize(node.right, lvl+1));
        if(!firstMaxInLevel.containsKey(lvl)) {
            firstMaxInLevel.put(lvl, curr);
        } else if(!secondMaxInLevel.containsKey(lvl)) {
            if(firstMaxInLevel.get(lvl) > curr) secondMaxInLevel.put(lvl, curr);
            else {
                secondMaxInLevel.put(lvl, firstMaxInLevel.get(lvl));
                firstMaxInLevel.put(lvl, curr);
            }
        } else {
            int first = firstMaxInLevel.get(lvl), second = secondMaxInLevel.get(lvl);
            if(curr >= first) {
                secondMaxInLevel.put(lvl, firstMaxInLevel.get(lvl));
                firstMaxInLevel.put(lvl, curr);
            } else if(curr > second) {
                secondMaxInLevel.put(lvl, curr);
            }
        }
        map.put(node.val, curr);
        nodeLevel.put(node.val, lvl);
        return curr;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        map = new HashMap<>();
        nodeLevel = new HashMap<>();
        ansMap = new HashMap<>();
        dfsSize(root, 0);
        // for(List<Integer> lt:levels) System.out.println(lt.toString());
        // for(Map.Entry<Integer, Integer> lt:map.entrySet()) System.out.println(lt.getKey()+" "+lt.getValue());
        int m = queries.length;
        int[] ans = new int[m];
        for(int i=0; i<m; i++) {
            int qry = queries[i], lvl = nodeLevel.get(qry), max = 0;
            if(ansMap.containsKey(qry)) {
                ans[i] = ansMap.get(qry);
                continue;
            }
            if(!secondMaxInLevel.containsKey(lvl)) ans[i] = nodeLevel.get(qry)-1;
            else {
                int first = firstMaxInLevel.get(lvl), second = secondMaxInLevel.get(lvl);
                int currMaxDepth = map.get(qry);
                if(first > currMaxDepth || second == currMaxDepth) ans[i] = first;
                else {
                    ans[i] = second;
                }
            }
            ansMap.put(qry, ans[i]);
        }
        return ans;
    }
}