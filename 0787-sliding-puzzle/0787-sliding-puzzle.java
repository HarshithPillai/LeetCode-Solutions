class Solution {
    class Node {
        int[][] board;
        int row, col;
        Node(int[][] board, int row, int col) {
            this.board = deepcopy(board);
            this.row = row;
            this.col = col;
        }
    }
    public int[][] deepcopy(int[][] arr) {
        int[][] board = new int[2][3];
        for(int i=0; i<2; i++) {
            for(int j = 0; j<3; j++) {
                board[i][j] = arr[i][j];
            }
        }
        return board;
    }
    public String state(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int[] arr:board) {
            for(int val:arr) {
                sb.append(String.valueOf(val));
            }
        }
        return new String(sb);
    }
    public void swap(int[][] board, int x1, int y1, int x2, int y2) {
        int temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
    int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public int slidingPuzzle(int[][] board) {
        int r=0, c=0, n=2, m=3;
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    r = i;
                    c = j;
                }
            }
        }
        int steps=0;
        q.add(new Node(board, r, c));
        Set<String> visited = new HashSet<>();
        visited.add(state(board));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node top = q.poll();
                String state = state(top.board);
                if(state.equals("123450")) return steps;
                for(int k=0; k<4; k++) {
                    int newr = top.row + dx[k], newc = top.col + dy[k];
                    if(newr >= 0 && newc >= 0 && newr < 2 && newc < 3) {
                        swap(top.board, top.row, top.col, newr, newc);
                        String newState = state(top.board);
                        if(!visited.contains(newState)) {
                            visited.add(newState);
                            q.add(new Node(top.board, newr, newc));
                        }
                        swap(top.board, top.row, top.col, newr, newc);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}