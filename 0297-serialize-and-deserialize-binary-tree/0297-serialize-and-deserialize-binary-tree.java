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
        if(root==null) return "#";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node==null) {
                res.append("#,");
                continue;
            }
 
            res.append(node.val+",");
            
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data: "+data);
        String[] arr = data.split(",");
        int n = arr.length;
        if(arr[0]=="#") return null;
        Queue<TreeNode> q = new LinkedList<>();
        int ind=1;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        
        while(!q.isEmpty()&& ind<n) {
            TreeNode node = q.poll();
            if(arr[ind].equals("#")) node.left=null;
            else {
                node.left = new TreeNode(Integer.parseInt(arr[ind]));
                q.add(node.left);
            }
            ind++;
            if(arr[ind].equals("#")) node.right=null;
            else {
                node.right = new TreeNode(Integer.parseInt(arr[ind]));
                q.add(node.right);
            }
            ind++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));