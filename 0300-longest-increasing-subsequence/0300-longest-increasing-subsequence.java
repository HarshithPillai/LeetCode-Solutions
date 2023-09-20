class Solution {
    public int helper(int[] nums, int i, int last, int n, int[][] dp) {
        if(i==n) return 0;
        if(dp[i][last+1]!=-1) return dp[i][last+1];
        int take=0;
        if(last==-1 || nums[i]>nums[last]) {
            take=1+helper(nums,i+1,i,n, dp);
        }
        int dont=helper(nums,i+1,last,n, dp);
        int res = Math.max(take,dont);
        
        return dp[i][last+1]=res;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        //for(int[] i:dp) Arrays.fill(i,-1);
        // for(int i=n-1;i>=0;i--) {
        //     int[] dp1 = new int[n+1];
        //     for(int j=i-1;j>=-1;j--) {
        //         if(j==-1||nums[i]>nums[j]) {
        //             dp1[j+1]=1+dp[i+1];
        //         }
        //         dp1[j+1]=Math.max(dp1[j+1],dp[j+1]);
        //     }
        //     dp=dp1;
        // }
        // return dp[0];
        Arrays.fill(dp,1);
        // each element in itself is an inceasing subsequence
        int max=1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i]>nums[j] && dp[i]<dp[j]+1) {
                    dp[i]=dp[j]+1;
                }
                max=Math.max(max,dp[i]);
            }
        }
        
        return max;
    }
}