class Solution {
    public int maxScore(int[] nums, int k) {
        /**
            take a card from either end
            take exactly k cards
            score is the total sum of picked cards
            return max score
        */
        int ans = 0, l=0, r = 0, sum = 0, n = nums.length;
        for(int v:nums) sum+=v;
        if(k==n) return sum;
        int curr = 0;
        while(r<n-k-1) {
            curr+=nums[r];
            r++;
        }
        while(r<n) {
            curr+=nums[r];
            ans = Math.max(ans, sum-curr);
            curr-=nums[l];
            l++; r++;
        }

        return ans;
    }
}