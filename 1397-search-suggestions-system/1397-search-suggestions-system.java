class Solution {
    class Node {
        Node[] arr = new Node[26];
        Set<String> set;
        Node() {
            set = new TreeSet<>();
        }
        public void put(char ch, Node node) {
            arr[ch - 'a'] = node;
        }
        public Node get(char ch) {
            return arr[ch-'a'];
        }
    }
    class Trie {
        Node root;
        Trie() {
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
                curr.set.add(word);
            }
        }
        public List<List<String>> fetch(String word) {
            char[] charr = word.toCharArray();
            List<List<String>> res = new ArrayList<>();
            Node curr = root;
            for(int ind=0; ind < charr.length; ind++) {
                char ch = charr[ind];
                if(curr.get(ch) == null) {
                    List<String> lt = new ArrayList<>();
                    while(ind < charr.length) {
                        res.add(lt);
                        ind++;
                    }
                    break;
                } else {
                    curr = curr.get(ch);
                    int i=0;
                    List<String> lt = new ArrayList<>();
                    for(String st:curr.set) {
                        lt.add(st);
                        i++;
                        if(i==3) break;
                    }
                    res.add(lt);
                }
            }
            return res;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for(String prod:products) {
            trie.insert(prod);
        }
        return trie.fetch(searchWord);
    }
}