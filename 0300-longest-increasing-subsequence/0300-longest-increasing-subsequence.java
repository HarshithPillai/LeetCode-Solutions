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
        int[][] dp = new int[n+1][n+1];
        //for(int[] i:dp) Arrays.fill(i,-1);
        for(int i=n-1;i>=0;i--) {
            for(int j=i-1;j>=-1;j--) {
                if(j==-1||nums[i]>nums[j]) {
                    dp[i][j+1]=1+dp[i+1][i+1];
                }
                dp[i][j+1]=Math.max(dp[i][j+1],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}