class Node {
    Node arr[];
    boolean flag = false;

    Node() {
        arr = new Node[26];
    }

    Node get(char ch) {
        return arr[ch - 'a'];
    }

    void put(char ch, Node node) {
        arr[ch - 'a'] = node;
    }

    void setEnd(boolean flag) {
        this.flag = flag;
    }

    boolean isEnd() {
        return flag;
    }
}
class Trie {
    
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
        curr.setEnd(true);
    }
    
    public boolean search(String word) {
        char[] charr = word.toCharArray();
        Node curr = root;
        for(char ch:charr) {
            if(curr.get(ch) == null) return false;
            curr = curr.get(ch);
        }
        return curr.isEnd();
    }
    
    public boolean startsWith(String word) {
        char[] charr = word.toCharArray();
        Node curr = root;
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