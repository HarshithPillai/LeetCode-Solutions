class Solution {
public:
    int N, dp[21][3001];
    int dfs(vector<int>& nums, int ind, int s) {
        if(ind==N) {
            if(s == 0) return 1;
            else return 0;
        }
        if(dp[ind][s+1000]!=-1) return dp[ind][s+1000];
        int res = 0;
        res = dfs(nums, ind+1, s-nums[ind]) + dfs(nums, ind+1, s+nums[ind]);
        return dp[ind][s+1000] = res;
    }
    int findTargetSumWays(vector<int>& nums, int s) {
        N = nums.size();
        if(s>1000) return 0;
        memset(dp,-1,sizeof(dp));
        return dfs(nums, 0, s);
    }
};