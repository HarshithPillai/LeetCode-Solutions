class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        nums.add(1);
        StringBuilder str = new StringBuilder();
        Stack<StringBuilder> st = new Stack<>();
        st.add(str);
        char[] arr = s.toCharArray();
        int n = 0;
        for(char ch:arr) {
            if(Character.isDigit(ch)) {
                n = n*10 + (int)(ch - '0');
                // System.out.println(new String(st.peek()));
            } else if(ch == '[') {
                nums.add(n);
                n = 0;
                st.add(new StringBuilder());
            } else if(ch == ']') {
                int val = nums.pop();
                StringBuilder top = st.pop();
                StringBuilder temp = new StringBuilder();
                while(val-- > 0) {
                    temp.append(top);
                }

                st.peek().append(temp);
            } else {
                st.peek().append(ch);
            }
        }
        return new String(st.peek());
    }
}