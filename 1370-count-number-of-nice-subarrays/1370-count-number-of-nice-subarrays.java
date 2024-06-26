class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length, next[] = new int[n], last = n;
        for(int i=n-1; i>=0; i--) {
            next[i] = last;
            if((nums[i]&1)==1) last = i;
        }
        int l=0, r=0, odd=0, count = 0;
        while(r<n) {
            odd+=(nums[r]&1);
            while(odd==k) {
                count += next[r]-r;
                odd-=(nums[l]&1);
                l++;
            }
            r++;
        }
        return count;
    }
}