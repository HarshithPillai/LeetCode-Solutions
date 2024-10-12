class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> nge = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!nge.isEmpty() && temp[nge.peek()] <= temp[i]) nge.pop();
            if(nge.isEmpty()) ans[i] = 0;
            else ans[i] = nge.peek() - i;
            nge.push(i);
        }
        return ans;
    }
}