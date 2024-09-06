class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        char[] arr = num.toCharArray();
        int ind = 0, n = num.length();
        // keep a monotonic stack
        // and only remove till you have some k left
        for(char ch:arr) {
            while(!st.isEmpty() && k>0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            if(st.isEmpty() && ch == '0') continue;
            else st.push(ch);
        }
        while(!st.isEmpty() && k>0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        char[] newarr = new char[st.size()];
        for(int i=st.size()-1; i>=0; i--) {
            newarr[i] = st.pop();
        }
        return new String(newarr);
    }
}