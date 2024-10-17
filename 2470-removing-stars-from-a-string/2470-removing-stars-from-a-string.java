class Solution {
    public String removeStars(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char ch:arr) {
            if(ch == '*') {
                if(!st.isEmpty()) st.pop();
            } else {
                st.add(ch);
            }
        }
        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}