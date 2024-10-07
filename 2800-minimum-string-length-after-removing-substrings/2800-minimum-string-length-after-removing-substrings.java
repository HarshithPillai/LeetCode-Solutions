class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length(), res = n;
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!st.isEmpty()) {
                if(ch == 'B' && st.peek() == 'A') {
                    st.pop();
                    res -= 2;
                } else if(ch == 'D' && st.peek() == 'C') {
                    st.pop();
                    res -= 2;
                } else {
                    st.push(ch);
                }
            } else {
                st.push(ch);
            }
        }
        return res;
    }

}