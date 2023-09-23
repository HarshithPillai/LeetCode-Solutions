class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length, count=0, max=1;
        int dp[] = new int[n];
        int ways[] = new int[n];
        for(int i=0;i<n;i++) {
            dp[i]=1; ways[i]=1;
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j]) {
                    if(dp[i]<dp[j]+1) {
                        dp[i]=dp[j]+1;
                        ways[i]=ways[j];
                    } else if(dp[i]==(dp[j]+1)) {
                        ways[i]+=ways[j];
                    }
                }
            }
            if(max<dp[i]) {
                max=dp[i];
            }
        }
        for(int i=0;i<n;i++) {
            if(max==dp[i]) count+=ways[i];
        }
        return count;
    }
}