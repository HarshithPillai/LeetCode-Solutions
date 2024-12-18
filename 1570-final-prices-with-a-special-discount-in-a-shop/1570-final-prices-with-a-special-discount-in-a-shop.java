class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            int curr = prices[i];
            prices[i] = curr - (st.isEmpty()?0:st.peek());
            st.add(curr);
        }
        return prices;
    }
}