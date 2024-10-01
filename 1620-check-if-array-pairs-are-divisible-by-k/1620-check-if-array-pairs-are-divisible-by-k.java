class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        int count = 0, n = arr.length;
        for(int i=0; i<n; i++) {
            int ind = (arr[i] % k + k) % k;
            mod[ind]++;
        }
        if(mod[0] % 2 != 0) return false;
        for(int i=1; i<=k/2; i++) {
            int ind = k-i;
            if(mod[i] != mod[ind]) {
                return false;
            }
        }
        return true;
    }
}