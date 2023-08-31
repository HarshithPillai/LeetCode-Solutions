/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "null";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }


    public TreeNode recBuild(Queue<String> q) {
        if(q.isEmpty()) return null;
        String element = q.poll();
        if(element.equals("null")) return null;
        int val=Integer.valueOf(element);
        TreeNode root = new TreeNode(val);
        root.left =recBuild(q);
        root.right=recBuild(q);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return recBuild(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));