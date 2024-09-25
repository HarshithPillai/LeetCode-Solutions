class Solution {
    class Node {
        Node[] arr;
        int countPrefix = 0;
        int endsWith = 0;
        
        public Node() {
            arr = new Node[26];
        }

        public void increaseCount() {
            countPrefix++;
        }

        public void increaseEndsWith() {
            endsWith++;
        }

        public Node get(char ch) {
            return arr[ch - 'a'];
        }

        public void put(char ch, Node node) {
            arr[ch - 'a'] = node;
        }

        public int getCountPrefix() {
            return countPrefix;
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
                curr.increaseCount();
            }
            curr.increaseEndsWith();
        }

        public int countPrefix(String word) {
            char[] charr = word.toCharArray();
            Node curr = root;
            int count = 0;
            for(char ch:charr) {
                curr = curr.get(ch);
                if(curr == null) break;
                count+= curr.getCountPrefix();
            }
            return count;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        Trie trie = new Trie();
        for(String s:words) trie.insert(s);
        for(int i=0; i<n; i++) {
            ans[i] = trie.countPrefix(words[i]);
        }
        return ans;
    }
}