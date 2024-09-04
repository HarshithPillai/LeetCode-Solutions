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
}