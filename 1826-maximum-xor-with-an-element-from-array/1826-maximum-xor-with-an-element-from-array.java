class Solution {
    class Node {
        Node arr[];
        
        public Node() {
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
        public int getMax(int val) {
            Node curr = root;
            if(curr.get(0) == null && curr.get(1) == null) return -1;
            int ans = 0;
            for(int i=30; i>=0; i--) {
                int shift = 1<<i;
                int bitmask = val & (shift);

                if(bitmask != 0) bitmask = 0;
                else bitmask = 1;

                if(curr.get(bitmask) == null) {
                    bitmask ^= 1;
                }
                curr = curr.get(bitmask);
                if(bitmask == 1) ans += shift;
            }
            return val ^ ans;
        }
        public void insert(int val) {
            Node curr = root;
            for(int i=30; i>=0; i--) {
                int bitmask = val & (1<<i);
                if(bitmask != 0) bitmask = 1;
                if(curr.get(bitmask) == null) {
                    curr.put(bitmask, new Node());
                }
                curr = curr.get(bitmask);
            }
        }
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int[][] q = new int[n][3];
        for(int i=0; i<n; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a,b)->Integer.compare(a[1], b[1]));
        Arrays.sort(nums);
        int ind = 0;
        Trie trie = new Trie();
        for(int i=0; i<n; i++) {
            int x = q[i][0], a = q[i][1];
            while(ind < nums.length && nums[ind] <= a) {
                trie.insert(nums[ind]);
                ind++;
            }
            int max = trie.getMax(x);
            ans[q[i][2]] = max;
        }
        return ans;
    }
}