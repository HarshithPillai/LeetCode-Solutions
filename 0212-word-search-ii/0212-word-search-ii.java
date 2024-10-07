class Solution {
    int n, m, dx[] = {1,0,-1,0}, dy[] = {0,-1,0,1};
    class Node {
        Node[] arr;
        String word;
        Node() {
            arr = new Node[26];
        }
        public void put(char ch, Node node) {
            arr[ch - 'a'] = node;
        }
        public Node get(char ch) {
            return arr[ch - 'a'];
        }
    }

    public void insert(String word, Node root) {
        Node curr = root;
        char[] arr = word.toCharArray();
        for(char ch:arr) {
            if(curr.get(ch) == null) {
                curr.put(ch, new Node());
            }
            curr = curr.get(ch);
        }
        curr.word = word;
    }

    public void dfs(Node node, char[][] board, int i, int j, Set<String> set) {
        char ch = board[i][j];
        if(node.get(ch) == null) return;
        if(node.get(ch).word != null) {
            set.add(node.get(ch).word);
        }
        board[i][j] = '*';
        for(int k=0; k<4; k++) {
            int newr = i + dx[k], newc = j + dy[k];
            if(newr < n && newc < m && newr>=0 && newc>=0 && board[newr][newc] != '*') {
                dfs(node.get(ch), board, newr, newc, set);
            }
        }
        board[i][j] = ch;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        n = board.length;
        m = board[0].length;
        Set<String> list = new HashSet<>();
        for(String word:words) {
            char[] arr = word.toCharArray();
            Node curr = root;
            for(char ch:arr) {
                if(curr.get(ch) == null) {
                    curr.put(ch, new Node());
                }
                curr = curr.get(ch);
            }
            curr.word = word;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dfs(root, board, i, j, list);
            }
        }
        
        return new ArrayList<>(list);
    }
}