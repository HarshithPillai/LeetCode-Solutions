class Solution {
    class Node {
        Node arr[];
        boolean flag = false;
        int endsWith = 0;
        int countPrefix = 0;

        Node() {
            arr = new Node[26];
        }

        public Node get(char ch) {
            return arr[ch - 'a'];
        }

        public void put(char ch, Node node) {
            arr[ch - 'a'] = node;
        }

        public int countEnd() {
            return endsWith;
        }

        public int countPrefix() {
            return countPrefix;
        }

        public void increasePrefix() {
            countPrefix++;
        }

        public void increaseEndsWith() {
            endsWith++;
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            char charr[] = word.toCharArray();
            
            Node curr = root;
            
            for(char ch : charr) {
                if(curr.get(ch) == null) {
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
                curr.increasePrefix();
            }
            curr.increaseEndsWith();
        }

        public int startsWith(String prefix) {
            Node curr = root;
            int count = 0;
            char charr[] = prefix.toCharArray();

            for(char ch : charr) {
                if(curr.get(ch) == null) return 0;
                curr = curr.get(ch);
            }
            // curr is at the end of the prefix
            // now do a dfs to count all the nodes with flag true
            count = curr.countEnd();
            for(int i=0; i<26; i++) {
                char newCh = (char)(i+'a');
                Node next = curr.get(newCh);
                if(next != null) {
                    count += dfs(next);
                }
            }
            return count;
        }

        public int dfs(Node curr) {
            int count = curr.countEnd();
            for(int i=0; i<26; i++) {
                char newCh = (char)(i+'a');
                Node next = curr.get(newCh);
                if(next != null) {
                    count += dfs(next);
                }
            }
            return count;
        }
    }

    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word:words) trie.insert(word);
        return trie.startsWith(pref);
    }
}