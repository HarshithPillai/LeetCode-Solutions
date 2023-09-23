class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int dp[] = new int[n];
        int parent[] = new int[n];
        int max=1, start=0;
        for(int i=0;i<n;i++) {
            dp[i]=1; parent[i]=i;
            for(int j=0;j<i;j++) {
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if(max<dp[i]) {
                max=dp[i];
                start=i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(start!=parent[start]) {
            res.add(nums[start]);
            start=parent[start];
        }
        res.add(nums[start]);
        Collections.reverse(res);
        return res;
    }
}