class Solution {
    public boolean isCircularSentence(String sentence) {
        char[] arr = sentence.toCharArray();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            char ch = arr[i];
            if(ch == ' ') {
                if(i==0 || i==n-1 || arr[i-1] != arr[i+1]) {
                    return false;
                }
            }
        }
        return arr[n-1] == arr[0];
    }
}