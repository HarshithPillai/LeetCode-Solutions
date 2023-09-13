class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int dp0[] = new int[n];
        
        dp0[0]=nums[0];
        dp0[1]=Math.max(dp0[0], nums[1]);
        for(int i=2;i<n-1;i++) {
            int pick = dp0[i-2]+nums[i];
            int notPick = dp0[i-1];
            dp0[i]=Math.max(pick,notPick);
        }
        int dp1[] = new int[n];
        dp1[1] = nums[1];
        dp1[2] = Math.max(dp1[1], nums[2]);
        for(int i=3;i<n;i++) {
            int pick = dp1[i-2] + nums[i];
            int notPick = dp1[i-1];
            dp1[i]=Math.max(pick, notPick);
        }
        return Math.max(dp0[n-2], dp1[n-1]);
    }
}