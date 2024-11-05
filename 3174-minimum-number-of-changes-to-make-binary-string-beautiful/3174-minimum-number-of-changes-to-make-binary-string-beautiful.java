class Solution {
    public int minChanges(String s) {
        char[] arr = s.toCharArray();
        int ans = 0, n = s.length();
        for(int i=1; i<n; i+=2) {
            if(arr[i] != arr[i-1]) {
                ans++;
            }
        }
        return ans;
    }
}