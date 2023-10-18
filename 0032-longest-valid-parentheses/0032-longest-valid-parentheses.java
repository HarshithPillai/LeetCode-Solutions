class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        char[] arr = s.toCharArray();
        
        int max = 0;
        for(int i = 0; i<arr.length; i++) {
            char a = arr[i];
            if(a == '(') {
                st.push(i);
            } else {
                st.pop();
                if(!st.isEmpty()) {
                    int ind = st.peek();
                    max = Math.max(max, i-ind);
                } else st.push(i);
            }
        }
        return max;
    }
}