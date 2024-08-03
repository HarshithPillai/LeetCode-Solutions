class Solution {
    public int minimumDeletions(String st) {
        int n = st.length(), countA[] = new int[n], count = 0;
        char[] s = st.toCharArray();
        for(int i=n-1; i>=0; i--) {
            countA[i] = count;
            if(s[i] == 'a') count++;
        }
        count = 0;
        int min = n;
        for(int i=0; i<n; i++) {
            min = Math.min(count + countA[i], min);
            if(s[i]== 'b') count++;
        }
        return min;
    }
}