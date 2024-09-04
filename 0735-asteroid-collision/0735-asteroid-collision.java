class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i:asteroids) {
            if(i>=0) st.push(i);
            else {
                while(!st.isEmpty() && st.peek() < -i && st.peek()>=0) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == -i) st.pop();
                else if(!st.isEmpty() && st.peek() > -i) {
                    continue;
                } else st.push(i);
            }
        }
        int n = st.size(), ans[] = new int[n];
        for(int ind=n-1; ind>=0; ind--) {
            ans[ind] = st.pop();
        }
        return ans;
    }
}