class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, n = nums.length, jumps = 0;
        while(r<n-1) {
            int max=r;
            for(int ind=l; ind<=r ; ind++) {
                max = Math.max(max, nums[ind]+ind);
            }
            l=r+1;
            r=max;
            jumps++;
        }
        return jumps;
    }
}