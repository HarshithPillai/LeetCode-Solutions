class Solution {
    public char findKthBit(int n, int k) {
        List<Character> st = new ArrayList<>();
        st.add('0');

        while(st.size() < k) {
            int size = st.size();
            st.add('1');
            for(int i=size-1; i>=0; i--) {
                if(st.get(i) == '0') st.add('1');
                else st.add('0');
            }
        }

        return st.get(k-1);
    }
}