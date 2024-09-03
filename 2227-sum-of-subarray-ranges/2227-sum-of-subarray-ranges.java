class Solution {
    public long subArrayRanges(int[] nums) {
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
        

        st = new Stack<>();
        int[] nge = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            if(st.isEmpty()) {
                nge[i] = n;
            } else {
                nge[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        int[] pge = new int[n];
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            if(st.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }
            st.push(i);
        }

        for(int i = 0; i<n; i++) {
            // System.out.print(pse[i] + " ");
            res = (res + ((long)(nge[i]-i) * (long)(i-pge[i])) * (long)nums[i] - ((long)(ans[i]-i) * (long)(i-pse[i])) * (long)nums[i]);
        }
        
        return res;
    }
}