class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length, ans = 0;
        int[] nse = new int[n], pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) pse[i] = -1;
            else {
                pse[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty())  {
                ans = Math.max(ans, arr[i]*(n - pse[i] - 1));
            } else {
                ans = Math.max(ans, arr[i]*(st.peek() - pse[i] - 1));
            }
            st.push(i);
        }
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[] arr = new int[m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(arr));
        }
        return max;
    }
}