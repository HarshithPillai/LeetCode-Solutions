class Solution {
    public int sumSubarrayMins(int[] nums) {
        long MOD = 1_000_000_007;
        int n = nums.length;
        long res = 0;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if(st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        int pse[] = new int[n];
        for(int i = 0; i<n; i++) {
            // System.out.print(ans[i] + " ");
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            if(st.isEmpty()) {
                // res += (ans[i]-i) * nums[i];
                pse[i] = -1;
            } else {
                // res += ((ans[i]-i) * (i - st.peek() - 1)) * nums[i];
                pse[i] = st.peek();
            }
            st.push(i);
        }
        // System.out.println("");
        for(int i = 0; i<n; i++) {
            // System.out.print(pse[i] + " ");
            res = (res + ((long)(ans[i]-i) * (long)(i-pse[i])) * (long)nums[i]) % MOD;
        }

        return (int)res;
    }
}