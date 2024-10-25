class Solution {
    class Node {
        Node[] arr;
        boolean flag;
        Node() {
            arr = new Node[27];
            flag = false;
        }
        public void put(char ch, Node node) {
            if(ch == '/') arr[26] = node;
            else arr[ch - 'a'] = node;
        }
        public Node get(char ch) {
            if(ch == '/') return arr[26];
            else return arr[ch - 'a'];
        }
    }
    class Trie {
        Node root;
        Trie() {
            root = new Node();
        }
        public boolean insert(String word) {
            char[] charr = word.toCharArray();
            Node curr = root;
            boolean found = false;
            int n = charr.length;
            for(int ind = 0; ind < n; ind++) {
                char ch = charr[ind];
                if(curr.get(ch) == null) {
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
                if(curr.flag && (ind == n-1 || charr[ind+1] == '/')) return false;
            }
            curr.flag = true;
            return true;
        }
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for(String f:folder) {
            if(trie.insert(f)) res.add(f);
        }
        return res;
    }
}