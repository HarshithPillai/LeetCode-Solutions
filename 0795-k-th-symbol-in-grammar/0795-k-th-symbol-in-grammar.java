class Solution {
    public int kthGrammar(int n, int k) {
        int l = 1, r = 1<<(n-1), curr = 0;
        for(int i=0; i<n; i++) {
            int mid = (l+r)/2;
            if(k<=mid) {
                r = mid;
            } else {
                l=mid+1;
                curr = curr^1; // flip the bit
            }
        }
        return curr;
    }
}