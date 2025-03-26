class Solution {
    public int minOperations(int[][] grid, int x) {
        /**
            m * n grid, and an integer x
            add x or subtract x to/from any element in the grid
            return minimum number of operations required to make all the elements equal
            if it's not possible, return -1
        */
        int n = grid.length, m = grid[0].length, ind = 0, sum = 0, mod = grid[0][0] % x;
        int[] arr = new int[n * m], prefix = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % x != mod) return -1;
                arr[ind++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        n = n * m;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            prefix[i] = sum;
        }

        int min = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int leftreq = i * arr[i], op = 0, rightreq = (n - i - 1) * arr[i];
            if (leftreq > 0) op = (leftreq - prefix[i - 1]) / x;
            if (rightreq > 0) op += (prefix[n-1] - prefix[i] - rightreq) / x;
            min = Math.min(min, op);
        }
        return min;
    }
}