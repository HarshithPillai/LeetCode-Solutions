class Solution {
    public int trap(int[] arr) {
        int n = arr.length, l = 0, r = n-1;
        int maxL = 0, maxR = 0, ans = 0;
        while(l<r) {
            maxL = Math.max(maxL, arr[l]);
            maxR = Math.max(maxR, arr[r]);
            if(maxL < maxR) {
                ans += Math.max(0, maxL-arr[l]);
                l++;
            } else {
                ans += Math.max(0, maxR - arr[r]);
                r--;
            }
        }
        return ans;
    }
}