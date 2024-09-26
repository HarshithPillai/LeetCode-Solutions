class Solution {
    class Node {
        Node arr[];

        Node() {
            arr = new Node[2];
        }

        public void put(int ind, Node node) {
            arr[ind] = node;
        }

        public Node get(int ind) {
            return arr[ind];
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int val) {
            Node curr = root;
            for(int i=30; i>=0; i--) {
                int mask = val & (1<<i);

                if(mask != 0) mask = 1;
                
                if(curr.get(mask) == null) {
                    curr.put(mask, new Node());
                }
                curr = curr.get(mask);
            }
        }

        public int getMax(int val) {
            Node curr = root;
            int ans = 0;
            for(int i=30; i>=0; i--) {
                int mask = val & (1<<i);

                if(mask!=0) mask = 0;
                else mask = 1;

                if(curr.get(mask) == null) {
                    mask = (mask==1) ? 0 : 1;
                }
                curr = curr.get(mask);
                if(mask == 1) ans += (1<<i);
            }
            return ans^val;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for(int num:nums) trie.insert(num);
        int max = 0;
        for(int num:nums) {
            max = Math.max(max, trie.getMax(num));
        }
        return max;
    }
}