class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] sortedfrom = new int[n], ans = new int[n-k+1];
        for(int i=1; i<n; i++) {
            if(nums[i] == nums[i-1]+1) sortedfrom[i] = sortedfrom[i-1];
            else sortedfrom[i] = i;
        }
        for(int i=k-1; i<n; i++) {
            if(i - sortedfrom[i]+1 < k) ans[i-k+1] = -1;
            else ans[i-k+1] = nums[i];
        }
        return ans;
    }
}