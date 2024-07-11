class Solution {
    public void reverse(char[] arr, int l, int r) {
        while(l<r) {
            if(arr[l] == '(') {
                arr[l] = ')';
            }
            if(arr[r] == ')') {
                arr[r] = '(';
            }
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            r--;
            l++;
        }
    }
    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray();
        int l=0, n = s.length();
        Stack<Integer> st = new Stack<>();
        while(l<n) {
            if(arr[l] == '(') st.push(l);
            else if(arr[l] == ')') {
                reverse(arr, st.peek()+1, l-1);
                st.pop();
            }
            l++;
        }
        StringBuilder sb = new StringBuilder();
        for(char a:arr) {
            if(a != '(' && a != ')') sb.append(a);
        }
        return new String(sb);
    }
}