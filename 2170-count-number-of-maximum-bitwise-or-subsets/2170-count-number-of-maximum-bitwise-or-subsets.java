class Solution {
    int max = 0, count = 0;
    public void dfs(int[] nums, int ind, int total) {
        if(ind == -1) return;
        int curr = total | nums[ind];
        if(curr > max) {
            max = curr;
            count = 1;
        } else if(curr == max) {
            count++;
        }
        dfs(nums, ind-1, curr);
        dfs(nums, ind-1, total);
    }
    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, nums.length-1, 0);
        return count;
    }
}