class Solution {
    public int minimumDeletions(String s) {
        int n = s.length(), countA[] = new int[n];
        int count = 0;
        for(int i=n-1; i>=0; i--) {
            countA[i] = count;
            if(s.charAt(i) == 'a') count++;
        }
        count = 0;
        int min = n;
        for(int i=0; i<n; i++) {
            min = Math.min(count + countA[i], min);
            if(s.charAt(i)== 'b') count++;
        }
        return min;
    }
}