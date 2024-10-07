class WordDictionary {

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
            return arr[ch-'a'];
        }

        public boolean isEnd() {
            return this.flag;
        }

        public void setEnd(boolean flag) {
            this.flag = flag;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char[] arr = word.toCharArray();
            Node curr = root;
            for(char ch:arr) {
                if(curr.get(ch) == null) {
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
            }
            curr.setEnd(true);
        }

        public boolean contains(char[] arr, int ind, Node curr) {
            if(curr == null) return false;
            if(ind == arr.length) return curr.isEnd();
            char ch = arr[ind];
            if(ch == '.') {
                boolean res = false;
                for(int i=0; i<26; i++) {
                    res |= contains(arr, ind+1, curr.get((char)(i+'a')));
                }
                return res;
            } else {
                if(curr.get(ch) == null) return false;
                return contains(arr, ind+1, curr.get(ch));
            }
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.contains(word.toCharArray(), 0, trie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */