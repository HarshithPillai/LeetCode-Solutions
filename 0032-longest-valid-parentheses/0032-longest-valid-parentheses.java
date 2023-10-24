class Solution {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        /**
            stack keeps track of the last index encountered

        */
        int result = 0, n = arr.length;
        for(int i=0; i<n; i++) {
            if(arr[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                } else result = Math.max(result, i-stack.peek());
            }
        }
        return result;
    }
}