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
            // System.out.print(pse[i]+" ");
            st.push(i);
        }
        // System.out.print("\n");
        st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            if(st.isEmpty()) nse[i] = n;
            else {
                nse[i] = st.peek();
            }
            // System.out.print(nse[i]+" ");
            st.push(i);
        }
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, arr[i]*(nse[i] - pse[i] - 1));
        }
        return ans;
    }
}