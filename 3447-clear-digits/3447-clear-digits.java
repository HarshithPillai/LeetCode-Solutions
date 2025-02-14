class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch : arr) {
            if(ch <= '9' && ch >= '0') {
                if(!st.isEmpty()) st.pop();
            } else st.add(ch);
        }
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb = sb.reverse();
        return new String(sb);
    }
}