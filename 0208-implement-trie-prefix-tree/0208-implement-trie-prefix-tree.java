class Trie {

    class Node {
        Node[] arr;
        boolean flag;

        Node() {
            arr = new Node[26];
            flag = false;
        }

        public void put(char ch, Node node) {
            arr[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return arr[ch - 'a'];
        }

        public boolean isEnd() {
            return this.flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        char[] charr = word.toCharArray();
        Node curr = root;
        for(char ch:charr) {
            if(curr.get(ch) == null) {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.setFlag(true);
    }
        
    public boolean search(String word) {
        Node curr = root;
        char[] charr = word.toCharArray();
        for(char ch:charr) {
            if(curr.get(ch) == null) return false;
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        char[] charr = prefix.toCharArray();
        for(char ch:charr) {
            if(curr.get(ch) == null) return false;
            curr = curr.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */