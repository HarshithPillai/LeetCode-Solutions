class Solution {
    public int minPatches(int[] nums, int n) {
        /**
            loop over the array
            keep taking sum
        */
        int count = 0, i = 0;
        long maxYet = 0l;
        while(maxYet < n) {
            while(i<nums.length && nums[i]<=maxYet+1) {
                maxYet+=nums[i];
                i++;
            }
            if(maxYet>=n) break;
            
            maxYet += maxYet+1;
            count++;
            
        }
        return count;
    }
}