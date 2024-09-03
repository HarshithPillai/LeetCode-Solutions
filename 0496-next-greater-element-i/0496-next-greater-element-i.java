class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int n = nums1.length, m = nums2.length;
        int[] nge = new int[m];
        int[] ans = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; i++) {
            map.put(nums2[i], i);
        }
        for(int i=m-1; i>=0; i--) {
            while(!st.isEmpty() && nums2[st.peek()] <= nums2[i]) st.pop();
            if(st.isEmpty()) nge[i] = -1;
            else nge[i] = st.peek();
            st.push(i);
        }
        for(int i=0; i<m; i++) {
            System.out.print(nge[i] + " ");
        }
        for(int i=0; i<n; i++) {
            int index = map.get(nums1[i]);
            if(nge[index] == -1) ans[i] = -1;
            else ans[i] = nums2[nge[index]];
        }
        return ans;
    }
}